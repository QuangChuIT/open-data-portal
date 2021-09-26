// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringUtils
{
    static final char NINE = '9';
    static final char ZERO = '0';
    static final char CH_a = 'a';
    static final char CH_z = 'z';
    static final char CH_A = 'A';
    static final char CH_Z = 'Z';
    static final String uniChars = "\u00e0\u00e1\u1ea3\u00e3\u1ea1\u00e2\u1ea7\u1ea5\u1ea9\u1eab\u1ead\u0103\u1eb1\u1eaf\u1eb3\u1eb5\u1eb7\u00e8\u00e9\u1ebb\u1ebd\u1eb9\u00ea\u1ec1\u1ebf\u1ec3\u1ec5\u1ec7\u0111\u00ec\u00ed\u1ec9\u0129\u1ecb\u00f2\u00f3\u1ecf\u00f5\u1ecd\u00f4\u1ed3\u1ed1\u1ed5\u1ed7\u1ed9\u01a1\u1edd\u1edb\u1edf\u1ee1\u1ee3\u00f9\u00fa\u1ee7\u0169\u1ee5\u01b0\u1eeb\u1ee9\u1eed\u1eef\u1ef1\u1ef3\u00fd\u1ef7\u1ef9\u1ef5\u00c0\u00c1\u1ea2\u00c3\u1ea0\u00c2\u1ea6\u1ea4\u1ea8\u1eaa\u1eac\u0102\u1eb0\u1eae\u1eb2\u1eb4\u1eb6\u00c8\u00c9\u1eba\u1ebc\u1eb8\u00ca\u1ec0\u1ebe\u1ec2\u1ec4\u1ec6\u0110\u00cc\u00cd\u1ec8\u0128\u1eca\u00d2\u00d3\u1ece\u00d5\u1ecc\u00d4\u1ed2\u1ed0\u1ed4\u1ed6\u1ed8\u01a0\u1edc\u1eda\u1ede\u1ee0\u1ee2\u00d9\u00da\u1ee6\u0168\u1ee4\u01af\u1eea\u1ee8\u1eec\u1eee\u1ef0\u1ef2\u00dd\u1ef6\u1ef8\u1ef4\u00c2\u0102\u0110\u00d4\u01a0\u01af";
    static final String noneChars = "aaaaaaaaaaaaaaaaaeeeeeeeeeeediiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAAEEEEEEEEEEEDIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYYAADOOU";
    
    public static byte[] hexToByte(final String hex) {
        final int len = hex.length();
        final byte[] value = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            value[i / 2] = (byte)((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return value;
    }
    
    public static Collection parseString(final String text, final String seperator) {
        final Vector vResult = new Vector();
        if (text == null || "".equals(text)) {
            return vResult;
        }
        String tempStr = text.trim();
        String currentLabel = null;
        for (int index = tempStr.indexOf(seperator); index != -1; index = tempStr.indexOf(seperator)) {
            currentLabel = tempStr.substring(0, index).trim();
            if (!"".equals(currentLabel)) {
                vResult.addElement(currentLabel);
            }
            tempStr = tempStr.substring(index + 1);
        }
        currentLabel = tempStr.trim();
        if (!"".equals(currentLabel)) {
            vResult.addElement(currentLabel);
        }
        return vResult;
    }
    
    public static String encodeMD5(final String message) {
        try {
            final MessageDigest msgDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, msgDigest.digest(message.getBytes("UTF-8"))).toString(16);
        }
        catch (Exception e) {
            return message;
        }
    }
    
    public static Collection parseStringEx(final String text) {
        final Vector vResult = new Vector();
        if (text == null || "".equals(text)) {
            return vResult;
        }
        final String tempStr = text.trim();
        String currLabel = "";
        char currChar = '\0';
        for (int i = 0; i < tempStr.length(); ++i) {
            currChar = tempStr.charAt(i);
            if ((currChar >= '0' && currChar <= '9') || (currChar >= 'a' && currChar <= 'z') || (currChar >= 'A' && currChar <= 'Z')) {
                currLabel = String.valueOf(currLabel) + currChar;
            }
            else if (currLabel.length() > 0) {
                vResult.add(currLabel);
                currLabel = new String("");
            }
        }
        if (currLabel.length() > 0) {
            vResult.add(currLabel);
        }
        return vResult;
    }
    
    public static boolean isNumberic(final String sNumber) {
        if (sNumber == null || "".equals(sNumber)) {
            return false;
        }
        final char ch_max = '9';
        final char ch_min = '0';
        for (int i = 0; i < sNumber.length(); ++i) {
            final char ch = sNumber.charAt(i);
            if (ch < ch_min || ch > ch_max) {
                return false;
            }
        }
        return true;
    }
    
    public static String generateHexString(final long number, final int length) {
        String hex = Long.toHexString(number).toUpperCase();
        final int hexLength = hex.length();
        if (hexLength > length) {
            hex = hex.substring(hexLength - length);
        }
        else if (hexLength < length) {
            for (int i = 0; i < length - hexLength; ++i) {
                hex = "0" + hex;
            }
        }
        return hex;
    }
    
    public static String getPrefix(final String s) {
        String result = null;
        String[] tokens = null;
        final String seperator = " ";
        tokens = s.split(seperator);
        if (tokens == null) {
            result = s;
        }
        else {
            result = tokens[0];
        }
        return result;
    }
    
    public static Timestamp string2Timestamp(final String s) throws ParseException {
        Timestamp result = null;
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.F");
        final Date date = sdf.parse(s);
        result = new Timestamp(date.getTime());
        return result;
    }
    
    public static String SHA1(final String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return "";
    }
    
    public static String Collection2String(final Collection collect, final String delimiter) {
        final StringBuilder result = new StringBuilder();
        final Iterator it = collect.iterator();
        while (it.hasNext()) {
            result.append(delimiter);
            result.append(it.next());
        }
        return result.toString().substring(delimiter.length());
    }
    
    public static String Array2String(final String[] array, final String delimiter) {
        final StringBuilder result = new StringBuilder();
        result.append(array[0]);
        for (int i = 1; i < array.length; ++i) {
            result.append(delimiter);
            result.append(array[i]);
        }
        return result.toString();
    }
    
    public static String Array2StrSQL(final String[] array, final String delimiter) {
        final StringBuilder result = new StringBuilder();
        if (array != null && array.length > 0) {
            result.append("'" + array[0] + "'");
            for (int i = 1; i < array.length; ++i) {
                result.append(delimiter);
                result.append("'" + array[i] + "'");
            }
        }
        else {
            result.append("'VMS'");
        }
        return result.toString();
    }
    
    public static String ShortString(String s, final int num) {
        if (s != null && s.length() > num) {
            s = String.valueOf(s.substring(0, num / 2)) + "..." + s.substring(s.length() - num / 2 - 3, s.length());
        }
        return s;
    }
    
    public static String getXMLFormatString(String value) {
        while (value.indexOf("  ") >= 0) {
            value = value.replace("  ", " ");
        }
        return value.replace("&", "&amp;").replace(">", "&gt;").replace("<", "&lt;").replace("\"", "&quot;").replace("\u201c", "&quot;").replace("'", "&apos;").replace("\r\n", " \n");
    }
    
    public static String getStringXMLFormat(final String value) {
        return value.replace("&amp;", "&").replace("&gt;", ">").replace("&lt;", "<").replace("&quot;", "\"").replace("&quot;", "\u201c").replace("&apos;", "'").replace(" \n", "\r\n");
    }
    
    public static String unicode2ASII(final String s) {
        String ret = "";
        for (int i = 0; i < s.length(); ++i) {
            final int pos = "\u00e0\u00e1\u1ea3\u00e3\u1ea1\u00e2\u1ea7\u1ea5\u1ea9\u1eab\u1ead\u0103\u1eb1\u1eaf\u1eb3\u1eb5\u1eb7\u00e8\u00e9\u1ebb\u1ebd\u1eb9\u00ea\u1ec1\u1ebf\u1ec3\u1ec5\u1ec7\u0111\u00ec\u00ed\u1ec9\u0129\u1ecb\u00f2\u00f3\u1ecf\u00f5\u1ecd\u00f4\u1ed3\u1ed1\u1ed5\u1ed7\u1ed9\u01a1\u1edd\u1edb\u1edf\u1ee1\u1ee3\u00f9\u00fa\u1ee7\u0169\u1ee5\u01b0\u1eeb\u1ee9\u1eed\u1eef\u1ef1\u1ef3\u00fd\u1ef7\u1ef9\u1ef5\u00c0\u00c1\u1ea2\u00c3\u1ea0\u00c2\u1ea6\u1ea4\u1ea8\u1eaa\u1eac\u0102\u1eb0\u1eae\u1eb2\u1eb4\u1eb6\u00c8\u00c9\u1eba\u1ebc\u1eb8\u00ca\u1ec0\u1ebe\u1ec2\u1ec4\u1ec6\u0110\u00cc\u00cd\u1ec8\u0128\u1eca\u00d2\u00d3\u1ece\u00d5\u1ecc\u00d4\u1ed2\u1ed0\u1ed4\u1ed6\u1ed8\u01a0\u1edc\u1eda\u1ede\u1ee0\u1ee2\u00d9\u00da\u1ee6\u0168\u1ee4\u01af\u1eea\u1ee8\u1eec\u1eee\u1ef0\u1ef2\u00dd\u1ef6\u1ef8\u1ef4\u00c2\u0102\u0110\u00d4\u01a0\u01af".indexOf(s.charAt(i));
            if (pos >= 0) {
                ret = String.valueOf(ret) + "aaaaaaaaaaaaaaaaaeeeeeeeeeeediiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAAEEEEEEEEEEEDIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYYAADOOU".charAt(pos);
            }
            else {
                ret = String.valueOf(ret) + s.charAt(i);
            }
        }
        return ret;
    }
    
    public static boolean containsCase(final List<String> list, final String soughtFor, final boolean isIgnoreCase) {
        if (!isIgnoreCase) {
            return list.contains(soughtFor);
        }
        for (final String current : list) {
            if (current.equalsIgnoreCase(soughtFor)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isNullOrEmpty(final String strValue) {
        return strValue == null || strValue.trim().isEmpty();
    }
    
    public static String null2Empty(final String strValue) {
        return (strValue == null) ? "" : strValue;
    }
    
    public static String list2String(final ArrayList<?> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0).toString();
        }
        String res = "";
        for (int i = 0; i < list.size() - 1; ++i) {
            res = String.valueOf(res) + list.get(i).toString() + ", ";
        }
        return String.valueOf(res) + list.get(list.size() - 1).toString();
    }
    
    public static String list2String(final ArrayList<?> list, String demilator) {
        if (demilator == null || demilator.length() == 0) {
            demilator = ",";
        }
        if (list == null || list.size() <= 0) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0).toString();
        }
        String res = "";
        for (int i = 0; i < list.size() - 1; ++i) {
            res = String.valueOf(res) + list.get(i).toString() + demilator;
        }
        return String.valueOf(res) + list.get(list.size() - 1).toString();
    }
    
    public static String list2String(final ArrayList<?> list, String demilator, final String except) {
        if (demilator == null || demilator.length() == 0) {
            demilator = ",";
        }
        if (list == null || list.size() <= 0) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0).toString();
        }
        String res = "";
        for (int i = 0; i < list.size() - 1; ++i) {
            if (except == null || except.length() <= 0 || list.get(i).toString().compareTo(except) != 0) {
                res = String.valueOf(res) + list.get(i).toString() + demilator;
            }
        }
        return String.valueOf(res) + list.get(list.size() - 1).toString();
    }
}
