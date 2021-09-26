package vn.vnpt.cms.api.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final Log LOG = LogFactoryUtil.getLog(DateUtils.class);
    public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT_REVERSE = "dd/MM/yyyy";
    public static final String DATE_FORMAT_NEW = "yyyy-MM-dd";
    public static final String VN_DATETIME_FORMAT_NEW = "dd/MM/yyyy HH:mm:ss";

    public DateUtils() {
    }

    public static Date parse(String dateStrValue, String format) {
        if (StringUtil.isNullOrEmpty(dateStrValue)) {
            return null;
        } else {
            if (StringUtil.isNullOrEmpty(format)) {
                format = DEFAULT_DATE_FORMAT;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

            try {
                return simpleDateFormat.parse(dateStrValue);
            } catch (ParseException e) {
                LOG.warn("Could not parse [{" + dateStrValue + "}] to date with given format [{" + format + "}] to date", e);
                return null;
            }
        }
    }

    public static Date parse(String dateStrValue) {
        return parse(dateStrValue, DEFAULT_DATE_FORMAT_REVERSE);
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        } else {
            if (StringUtil.isNullOrEmpty(format)) {
                format = DEFAULT_DATE_FORMAT;
            }

            SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
            return localSimpleDateFormat.format(date);
        }
    }

    public static String format(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }
}
