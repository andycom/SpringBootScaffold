package com.fancv.util;

import org.apache.commons.lang3.StringUtils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalDateUtil {
    public static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String DEFAULT_DAY = "dd";
    public static String DEFAULT_MONTH = "MM";
    public static String DEFAULT_SHORT_YEAR = "yy";
    public static String DEFAULT_LONG_YEAR = "yyyy";
    public static String DEFAULT_PATTERN_YM = "yyyyMM";
    public static String DEFAULT_PATTERN_YMD = "yyyyMMdd";
    public static String DEFAULT_PATTERN_Y_M = "yyyy-MM";
    public static String DEFAULT_PATTERN_Y_M_D = "yyyy-MM-dd";
    public static String DEFAULT_PATTERN_Y_M_D_H_M_S_S = "yyyy-MM-dd HH:mm:ss.s";
    public static final String DEFAULT_PATTERN_TO_MONTH = "yyyy-MM";
    public static final String DEFAULT_PATTERN_TO_DAY = "yyyy-MM-dd";
    public static final String DEFAULT_PATTERN_TO_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_PATTERN_TO_MILLIS = "yyyy-MM-dd HH:mm:ss SSS";
    public static final long MILLIS_A_DAY = 86400000L;
    public static final long MILLIS_A_HOUR = 3600000L;
    public static final long MILLIS_A_MINUTE = 60000L;

    public LocalDateUtil() {
    }

    private static SimpleDateFormat getDateParser(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date currentDate() {
        return new Date();
    }

    public static String DateTimeString() {
        Format format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return format.format(new Date());
    }


    public static Date convertToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static Date convertToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static LocalDate convertToLocalDate(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static LocalDateTime convertToLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static Date addDate(Date date, int day) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return convertToDate(localDateTime.plusDays((long) day));
    }

    public static LocalDateTime addDate(LocalDateTime localDateTime, int day) {
        return localDateTime.plusDays((long) day);
    }

    public static Date addHour(Date date, int hour) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return convertToDate(localDateTime.plusHours((long) hour));
    }

    public static LocalDateTime addHour(LocalDateTime localDateTime, int hour) {
        return localDateTime.plusHours((long) hour);
    }

    public static Date addMinute(Date date, int minute) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return convertToDate(localDateTime.plusMinutes((long) minute));
    }

    public static LocalDateTime addMinute(LocalDateTime localDateTime, int minute) {
        return localDateTime.plusMinutes((long) minute);
    }

    public static Date addMonth(Date date, int month) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return convertToDate(localDateTime.plusMonths((long) month));
    }

    public static LocalDateTime addMonth(LocalDateTime localDateTime, int month) {
        return localDateTime.plusMonths((long) month);
    }

    public static Date addYear(Date date, int year) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return convertToDate(localDateTime.plusYears((long) year));
    }

    public static LocalDateTime addYear(LocalDateTime localDateTime, int year) {
        return localDateTime.plusYears((long) year);
    }

    public static long getMillis(Date date) {
        return date.toInstant().toEpochMilli();
    }

    public static long getMillis(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    public static Date toDate(String dateString) throws Exception {
        return getDateParser("yyyy-MM-dd").parse(dateString);
    }

    public static Date toDateTime(String dateString) throws Exception {
        return getDateParser("yyyy-MM-dd HH:mm:ss").parse(dateString);
    }

    public static String toDateString(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toDateString(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String toDateString(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String toDateString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String toDateString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static Date parseDateString(String dateString, String pattern) {
        if (StringUtils.isAnyEmpty(new CharSequence[]{dateString, pattern})) {
            return null;
        } else {
            LocalDateTime localDateTime;
            try {
                localDateTime = parseLocalDateTime(dateString, pattern);
            } catch (Exception var5) {
                LocalDate localDate = parseLocalDate(dateString, pattern);
                localDateTime = localDate == null ? null : localDate.atStartOfDay();
            }

            return convertToDate(localDateTime);
        }
    }

    public static LocalDate parseLocalDate(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    public static String dateFormat(Date date, String pattern) {
        return toDateString(convertToLocalDateTime(date), pattern);
    }

    public static Long minusToMills(Date time1, Date time2) {
        return minusToMills(convertToLocalDateTime(time1), convertToLocalDateTime(time2));
    }

    public static Long minusToMills(LocalDateTime time1, LocalDateTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    public static Long minusToMills(LocalTime time1, LocalTime time2) {
        return Duration.between(time1, time2).toMillis();
    }

    public static Long minusToMills(LocalDate time1, LocalDate time2) {
        return Duration.between(time1, time2).toMillis();
    }

    public static Period betweenLocalDate(LocalDate time1, LocalDate time2) {
        return Period.between(time1, time2);
    }

    public static Period betweenPeriod(Date date1, Date date2) {
        return betweenLocalDate(convertToLocalDate(date1), convertToLocalDate(date2));
    }

    public static Duration betweenLocalDateTime(LocalDateTime time1, LocalDateTime time2) {
        return Duration.between(time1, time2);
    }

    public static Duration betweenDuration(Date date1, Date date2) {
        return betweenLocalDateTime(convertToLocalDateTime(date1), convertToLocalDateTime(date1));
    }

    /**
     * 根据季度获取首月
     *
     * @param quarters
     * @return
     */
    public static String getFirshMonth(String quarters) {
        int m = Integer.parseInt(quarters);
        m = m * 3 - 2;
        String month;
        if (m > 0 && m < 10) {
            month = "0" + String.valueOf(m);
        } else {
            month = String.valueOf(m);
        }

        return month;
    }

    /**
     * 根据月份获取季度
     *
     * @param month
     * @return
     */
    public static String getQuarters(String month) {
        String quarters = null;
        int m = Integer.parseInt(month);
        if (m == 1 || m == 2 || m == 3) {
            quarters = "1";
        }

        if (m == 4 || m == 5 || m == 6) {
            quarters = "2";
        }

        if (m == 7 || m == 8 || m == 9) {
            quarters = "3";
        }

        if (m == 10 || m == 11 || m == 12) {
            quarters = "4";
        }

        return quarters;
    }

    public static String getWeekday(LocalDate localDate) {
        int week = localDate.get(WeekFields.of(DayOfWeek.of(1), 1).dayOfWeek());
        switch (week) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            default:
                return "星期天";
        }
    }

    public static String getWeekday(String dateString) {
        LocalDate localDate = parseLocalDate(dateString, "yyyy-MM-dd");
        int week = localDate.get(WeekFields.of(DayOfWeek.of(1), 1).dayOfWeek());
        switch (week) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            default:
                return "星期天";
        }
    }

    public static int getWeekOfYear(LocalDateTime localDateTime) {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return localDateTime.get(weekFields.weekOfYear());
    }

    public static int getWeekOfYear(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 1);
        return localDateTime.get(weekFields.weekOfYear());
    }

    public static int getDifferDays(Date dateBegin, Date dateEnd) {
        Period period = betweenPeriod(dateBegin, dateEnd);
        return period.getDays();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int getDifferOfDay(Date dateBegin, Date dateEnd) {
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dateBegin);
        calBegin.set(11, 0);
        calBegin.set(12, 0);
        calBegin.set(13, 0);
        calBegin.set(14, 0);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dateEnd);
        calEnd.set(11, 0);
        calEnd.set(12, 0);
        calEnd.set(13, 0);
        calEnd.set(14, 0);
        int days = (int) ((calEnd.getTimeInMillis() - calBegin.getTimeInMillis()) / 86400000L);
        days = Math.abs(days) + 1;
        return days;
    }

    public static int getDifferOfDayWithHour(Date dateBegin, Date dateEnd) {
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dateBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dateEnd);
        return (int) Math.ceil((double) Math.abs(calEnd.getTimeInMillis() - calBegin.getTimeInMillis()) / 8.64E7D);
    }

    public static int getDifferMonths(Date date1, Date date2) {
        Period period = betweenPeriod(date1, date2);
        return period.getMonths();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int getDifferOfMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal1.setTime(date1);
        return (cal1.get(1) - cal2.get(1)) * 12 + cal1.get(2) - cal2.get(2);
    }

    public static int getDifferYears(Date date1, Date date2) {
        Period period = betweenPeriod(date1, date2);
        return period.getYears();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static int getDifferOfYear(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal1.setTime(date1);
        return cal2.get(1) - cal1.get(1);
    }

    public static Date getFirstDayOfMonth(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return convertToDate(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static String getFirstDayOfMonth(String dateString) {
        Date date = parseDateString(dateString, "yyyy-MM-dd");
        return toDateString(getFirstDayOfMonth(date));
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static Date getFirstDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMinimum(5));
        return calendar.getTime();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static String getFirstDateOfMonth(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(getFirstDateOfMonth(sdf.parse(date)));
        } catch (ParseException var2) {
            return null;
        }
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static String getFirstDateOfWeek(String datestr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(datestr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(7, 1);
            return sdf.format(cal.getTime());
        } catch (ParseException var4) {
            return null;
        }
    }

    public static Date getFirstDayOfWeek(Date date) {
        LocalDate localDate = convertToLocalDate(date);
        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        return convertToDate(localDate.with(temporalField, 1L));
    }

    public static String getFirstDayOfWeek(String dateString) {
        LocalDate date = parseLocalDate(dateString, "yyyy-MM-dd");
        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        return toDateString(localDate.with(temporalField, 1L));
    }

    public static Date getLastDayOfWeek(Date date) {
        LocalDate localDate = convertToLocalDate(date);
        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        return convertToDate(localDate.with(temporalField, 7L));
    }

    public static String getLastDayOfWeek(String dateString) {
        LocalDate date = parseLocalDate(dateString, "yyyy-MM-dd");
        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        return toDateString(localDate.with(temporalField, 7L));
    }

    public static Date getLastDayOfMonth(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return convertToDate(localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static String getLastDayOfMonth(String dateString) {
        Date date = parseDateString(dateString, "yyyy-MM-dd");
        return toDateString(getLastDayOfMonth(date));
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static Date getLastDateOfMonth(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMaximum(5));
        return calendar.getTime();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static String getLastDateOfMonth(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(getLastDateOfMonth(sdf.parse(date)));
        } catch (ParseException var2) {
            return null;
        }
    }
}