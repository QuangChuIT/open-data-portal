// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil
{
    private static final String DEFAULT_PATERN = "dd/MM/yyyy HH:mm:ss";
    
    public static Date systemDate() {
        return new Date(System.currentTimeMillis());
    }
    
    public static String formatDate(final long datetime, final String patern) throws NullPointerException, IllegalArgumentException {
        return formatDate(new Date(datetime), patern);
    }
    
    public static String formatDate(final long datetime) {
        return formatDate(new Date(datetime), "dd/MM/yyyy HH:mm:ss");
    }
    
    public static String formatDate(final Date datetime) {
        return formatDate(datetime, "dd/MM/yyyy HH:mm:ss");
    }
    
    public static String formatDate(final Date d, final String patern) throws NullPointerException, IllegalArgumentException {
        if (d == null) {
            return null;
        }
        return new SimpleDateFormat(patern).format(d);
    }
    
    public static Date parse(final String date, final String patern) throws NullPointerException, IllegalArgumentException, ParseException {
        return new SimpleDateFormat(patern).parse(date);
    }
    
    public static Date parse(final String date) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
    }
    
    public static Date parseMyTime(String strTime) {
        final Calendar cal = Calendar.getInstance();
        final Pattern p = Pattern.compile("([DdMyhHmsS])(\\+?)([0-9]+)(.*)");
        for (Matcher matcher = null; strTime != null && !strTime.isEmpty(); strTime = matcher.group(4)) {
            matcher = p.matcher(strTime);
            if (!matcher.matches()) {
                throw new RuntimeException("Invalid datetime " + strTime);
            }
            final boolean relative = "+".equals(matcher.group(2)) || "-".equals(matcher.group(2));
            final int factor = "-".equals(matcher.group(2)) ? -1 : 1;
            if ("d".equalsIgnoreCase(matcher.group(1))) {
                final int d = Byte.parseByte(matcher.group(3));
                if (relative) {
                    cal.add(5, d * factor);
                }
                else {
                    if (d > 31 || d == 0) {
                        throw new RuntimeException("Invalid day " + strTime);
                    }
                    cal.add(5, d);
                }
            }
            else if ("M".equals(matcher.group(1))) {
                final int d = Byte.parseByte(matcher.group(3));
                if (relative) {
                    cal.add(2, d * factor);
                }
                else {
                    if (d > 12 || d == 0) {
                        throw new RuntimeException("Invalid month " + strTime);
                    }
                    cal.add(2, d);
                }
            }
            else if ("y".equalsIgnoreCase(matcher.group(1))) {
                int d = Integer.parseInt(matcher.group(3));
                if (relative) {
                    cal.add(1, d * factor);
                }
                else {
                    if (matcher.group(3).length() != 2 && matcher.group(3).length() != 4) {
                        throw new RuntimeException("Invalid year " + strTime);
                    }
                    if (matcher.group(3).length() == 2) {
                        d += 2000;
                    }
                    cal.add(1, d);
                }
            }
            else if ("h".equalsIgnoreCase(matcher.group(1))) {
                final int d = Byte.parseByte(matcher.group(3));
                if (relative) {
                    cal.add(11, d * factor);
                }
                else {
                    if (d > 23) {
                        throw new RuntimeException("Invalid hour " + strTime);
                    }
                    cal.add(11, d);
                }
            }
            else if ("m".equals(matcher.group(1))) {
                final int d = Byte.parseByte(matcher.group(3));
                if (relative) {
                    cal.add(12, d * factor);
                }
                else {
                    if (d > 59) {
                        throw new RuntimeException("Invalid minute " + strTime);
                    }
                    cal.add(12, d);
                }
            }
            else if ("s".equalsIgnoreCase(matcher.group(1))) {
                final int d = Byte.parseByte(matcher.group(3));
                if (relative) {
                    cal.add(13, d * factor);
                }
                else {
                    if (d > 59) {
                        throw new RuntimeException("Invalid second " + strTime);
                    }
                    cal.add(13, d);
                }
            }
        }
        return cal.getTime();
    }
}
