package io.github.izbk.export.util;

import net.cdsunrise.common.utility.AssertUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zbk
 * @date 2020/6/10 17:45
 */
public class DateUtil {
    public static final String PATTERN_YYYYMM = "yyyyMM";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYYMMDDHH = "yyyyMMddHH";
    public static final String PATTERN_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMMTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DateUtil() {
    }

    public static LocalDate stringToLocalDate(String str) {
        return LocalDate.parse(str, LOCAL_DATE_FORMATTER);
    }

    public static LocalDateTime stringToLocalDateTime(String str) {
        return LocalDateTime.parse(str, LOCAL_DATE_TIME_FORMMTER);
    }

    public static String localDateToString(LocalDate localDate) {
        return LOCAL_DATE_FORMATTER.format(localDate);
    }

    public static String localDateTimeToString(LocalDateTime localDate) {
        return LOCAL_DATE_TIME_FORMMTER.format(localDate);
    }

    public static LocalDateTime longToLocalDateTime(Long time) {
        AssertUtil.notNull(time, () -> {
            return new RuntimeException("时间格式错误");
        });

        try {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneOffset.ofHours(8));
        } catch (Exception var2) {
            throw new RuntimeException("时间格式错误");
        }
    }

    public static LocalDate longToLocalDate(Long time) {
        return longToLocalDateTime(time).toLocalDate();
    }

    public static Long localDateTimeToLong(LocalDateTime localDateTime) {
        AssertUtil.notNull(localDateTime, () -> {
            return new RuntimeException("时间格式错误");
        });

        try {
            return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        } catch (Exception var2) {
            throw new RuntimeException("时间格式错误");
        }
    }

    public static int calcDiffYearValueAbs(LocalDateTime start, LocalDateTime end) {
        return Math.abs(start.getYear() - end.getYear());
    }

    public static String convertLong2String(Long time) {
        return LOCAL_DATE_TIME_FORMMTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneOffset.ofHours(8)));
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static Date parse(String date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException var4) {
            throw new RuntimeException(var4);
        }
    }
}
