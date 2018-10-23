/*
 * $Id: TTName.java,v 1.2 2005/01/21 05:37:26 eed3si9n Exp $
 *
 * $Copyright: copyright (c) 2004, e.e d3si9n $
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
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
package org.doubletype.ossa.truetype;

public class TTName {

    public static final int k_unicode = 0;

    public static final int k_unicodeDefaultEncode = 0;

    public static final int k_macintosh = 1;

    public static final int k_macRomanEncode = 0;

    public static final int k_macEnglishLang = 0;

    public static final int k_microsoft = 3;

    public static final int k_winSymbolEncode = 0;

    public static final int k_winUnicodeEncode = 1;

    public static final int k_winShiftJisEncode = 2;

    public static final int k_winEnglishLang = 0x409;

    private int m_platformId;

    private int m_encodingId;

    private int m_languageId;

    private int m_nameId;

    private byte m_bytes[];

    public TTName(int a_platformId,
            int a_encodingId,
            int a_languageId,
            int a_nameId,
            byte a_bytes[]) {
        m_platformId = a_platformId;
        m_encodingId = a_encodingId;
        m_languageId = a_languageId;
        m_nameId = a_nameId;
        m_bytes = a_bytes;
    }

    public int getPlatformId() {
        return m_platformId;
    }

    public int getEncodingId() {
        return m_encodingId;
    }

    public int getLanguageId() {
        return m_languageId;
    }

    public int getNameId() {
        return m_nameId;
    }

    //	BUGFIX 958996
    public byte[] getBytes() {
        return m_bytes;
    }

    public int getStringLength() {
        return m_bytes.length;
    }
}
