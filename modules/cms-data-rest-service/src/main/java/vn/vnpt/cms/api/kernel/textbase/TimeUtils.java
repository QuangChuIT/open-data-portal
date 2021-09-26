// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.textbase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils
{
    public static String getDurations(final long l2, final long l1) {
        long ms = l2 - l1;
        if (ms < 0L) {
            ms = -ms;
        }
        final long s = ms / 1000L;
        final long ds = ms / 10000L;
        final long m = ms / 60000L;
        final String temp = "[" + ms + "ms," + s + "s," + ds + "ds," + m + "m]";
        return temp;
    }
    
    public static String getDescSeconds(final long ms) {
        final long s = ms / 1000L;
        final long ds = ms / 10000L;
        final long m = ms / 60000L;
        final String temp = "[" + ms + "ms," + s + "s," + ds + "ds," + m + "m]";
        return temp;
    }
    
    public static Date getDay() {
        final Calendar c = Calendar.getInstance();
        return new GregorianCalendar(c.get(1), c.get(2), c.get(5)).getTime();
    }
    
    public static Date addDay(final Date date, final int addDay) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(5, addDay);
        return new GregorianCalendar(c.get(1), c.get(2), c.get(5)).getTime();
    }
}
