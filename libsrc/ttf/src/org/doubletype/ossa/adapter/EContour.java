/*
 * $Id: EContour.java,v 1.11 2004/12/17 04:13:17 eed3si9n Exp $
 *
 * $Copyright: copyright (c) 2003-2004, e.e d3si9n $
 * $License:
 * This source code is part of DoubleType.
 * DoubleType is a graphical typeface designer.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This Program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * In addition, as a special exception, e.e d3si9n gives permission to
 * link the code of this program with any Java Platform that is available
 * to public with free of charge, including but not limited to
 * Sun Microsystem's JAVA(TM) 2 RUNTIME ENVIRONMENT (J2RE),
 * and distribute linked combinations including the two.
 * You must obey the GNU General Public License in all respects for all
 * of the code used other than Java Platform. If you modify this file,
 * you may extend this exception to your version of the file, but you are not
 * obligated to do so. If you do not wish to do so, delete this exception
 * statement from your version.
 * $
 */
package org.doubletype.ossa.adapter;

import java.util.ArrayList;

/**
 * @author e.e
 */
public class EContour {

    public static final String k_quadratic = "quadratic";

    public static final String k_cubic = "cubic";

    private String type;

    private ArrayList<EContourPoint> m_contourPoints = new ArrayList<>();

    public EContour() {
        setType(k_quadratic);
    }

    public boolean isCubic() {
        return type.equals(k_cubic);
    }

    public void setType(String a_type) {
        type = a_type;
    }

    public void addContourPoint(EContourPoint a_point) {
        m_contourPoints.add(a_point);
    }

    public ArrayList<EContourPoint> getContourPoints() {
        return m_contourPoints;
    }

    public EContour toQuadratic() {
        if (!isCubic()) {
            return this;
        }

        ArrayList<QuadraticSegment> quadraticSegments = new ArrayList<>();
        for (CubicSegment segment : CubicSegment.toSegments(this)) {
            quadraticSegments.addAll(segment.toQuadraticSegments());
        }

        return QuadraticSegment.toContour(quadraticSegments);
    }
}
