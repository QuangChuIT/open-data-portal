// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class StringUtil
{
    public static final String PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static final String[] PUNCTUATION_REGEX;
    public static String REGEX_HEXDIGIT_CHAR;
    public static String REGEX_NONE_HEXDIGIT_CHAR;
    public static String REGEX_WHITESPACE_CHAR;
    public static String REGEX_NONE_WHITESPACE_CHAR;
    public static String REGEX_CTRL_CHAR;
    public static String REGEX_DIGIT_CHAR;
    public static String REGEX_NONE_DIGIT_CHAR;
    public static String REGEX_WORD_CHAR;
    public static String REGEX_NONE_WORD_CHAR;
    
    static {
        PUNCTUATION_REGEX = new String[] { "\\x21", "\\x22", "\\x23", "\\x24", "\\x25", "\\x26", "\\x27", "\\x28", "\\x29", "\\x2a", "\\x2b", "\\x2c", "\\x2d", "\\x2e", "\\x2f", "\\x3a", "\\x3b", "\\x3c", "\\x3d", "\\x3e", "\\x3f", "\\x40", "\\x5b", "\\x5c", "\\x5d", "\\x5e", "\\x5f", "\\x60", "\\x7b", "\\x7c", "\\x7d", "\\x7e" };
        StringUtil.REGEX_HEXDIGIT_CHAR = "\\p{XDigit}";
        StringUtil.REGEX_NONE_HEXDIGIT_CHAR = "[^0-9a-fA-F]";
        StringUtil.REGEX_WHITESPACE_CHAR = "\\s";
        StringUtil.REGEX_NONE_WHITESPACE_CHAR = "\\S";
        StringUtil.REGEX_CTRL_CHAR = "\\p{Cntrl}";
        StringUtil.REGEX_DIGIT_CHAR = "\\d";
        StringUtil.REGEX_NONE_DIGIT_CHAR = "\\D";
        StringUtil.REGEX_WORD_CHAR = "\\w";
        StringUtil.REGEX_NONE_WORD_CHAR = "\\W";
    }
    
    public static String toHexString(final ByteBuffer data) {
        return new HexStringBuilder().append(data).toString();
    }
    
    public static String toHexString(final byte[] data) {
        return new HexStringBuilder().append(data).toString();
    }
    
    public static byte[] fromHexString(final String hexString) throws NumberFormatException {
        return Hex.parseData(hexString);
    }
    
    public static String fromAnsiCString(final byte[] cstr, final int offs, final int length) {
        return new CStringA(cstr, offs, length).str();
    }
    
    public static String fromAnsiCString(final byte[] cstr) {
        return fromAnsiCString(cstr, 0, cstr.length);
    }
    
    public static String readAnsiCString(final ByteBuffer buf) {
        return CStringA.readAnsiCString(buf);
    }
    
    public static void writeAnsiCString(final String s, final byte[] bs) {
        new CStringA(bs, 0, bs.length).copy(s);
    }
    
    public static void writeAnsiCString(final ByteBuffer buf, final String s) {
        CStringA.writeAnsiCString(buf, s);
    }
    
    public static String[] splitWords(final String str, final String regex) {
        final ArrayList<String> ar = new ArrayList<String>();
        String[] strings = split(str, regex);
        String[] array;
        for (int length = (array = strings).length, i = 0; i < length; ++i) {
            final String s = array[i];
            if (!s.isEmpty()) {
                ar.add(s);
            }
        }
        strings = new String[ar.size()];
        ar.toArray(strings);
        return strings;
    }
    
    public static String[] splitWords(final String str) {
        return splitWords(str, StringUtil.REGEX_WHITESPACE_CHAR);
    }
    
    public static String[] split(final String str, final String regex) {
        if (regex.length() == 1) {
            return split(str, regex.charAt(0));
        }
        return str.split(regex);
    }
    
    public static String nvl(final String test, final String return_if_null) {
        return (test == null) ? return_if_null : test;
    }
    
    public static String wsString(final String str) {
        return (str == null) ? "" : str;
    }
    
    public static boolean isNullOrEmpty(final String test) {
        return test == null || test.isEmpty();
    }
    
    public static String cutString(final String str, final int max_length) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        if (str.length() <= max_length) {
            return str;
        }
        return String.valueOf(str.substring(0, max_length)) + "...";
    }
    
    public static String[] split(final String str, final char separate) {
        final int i = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".indexOf(separate);
        if (i >= 0) {
            return str.split(StringUtil.PUNCTUATION_REGEX[i]);
        }
        return str.split(Character.toString(separate));
    }
    
    public static int[] splitAsInteger(final String str, final char separate) {
        final String[] sa = split(str, separate);
        if (sa == null) {
            return null;
        }
        final int[] ia = new int[sa.length];
        for (int i = 0; i < sa.length; ++i) {
            ia[i] = Integer.parseInt(sa[i]);
        }
        return ia;
    }
    
    public static String toString(final int[] cols, final String separate) {
        final StringBuilder s = new StringBuilder();
        if (cols.length == 0) {
            return "";
        }
        s.append(cols[0]);
        for (int i = 1; i < cols.length; ++i) {
            s.append(separate).append(cols[i]);
        }
        return s.toString();
    }
    
    public static String toString(final Object[] cols, final String separate) {
        final StringBuilder s = new StringBuilder();
        if (cols.length == 0) {
            return "";
        }
        s.append(cols[0]);
        for (int i = 1; i < cols.length; ++i) {
            s.append(separate).append(cols[i]);
        }
        return s.toString();
    }
    
    public static String toString(final Object o) {
        return (o == null) ? "null" : o.toString();
    }
}
