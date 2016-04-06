/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DateUtil.java, v 0.1 2014年7月29日 下午2:08:58 song.li@witontek.com Exp $
 */
public class DateUtil {

    /**
    * Logger for this class
    */
    private static final Logger   logger               = LoggerFactory.getLogger(DateUtil.class);

    public final static String    simpleFormat         = "M/d";
    public final static String    shortFormat          = "yyyyMMdd";
    public final static String    longFormat           = "yyyyMMddHHmmss";
    public final static String    webFormat            = "yyyy-MM-dd";
    public final static String    shortWebDateFormat   = "yyyy-MM";
    public final static String    timeFormat           = "HHmmss";
    public final static String    monthFormat          = "yyyyMM";
    public final static String    chineseDtFormat      = "yyyy年MM月dd日";
    public final static String    newFormat            = "yyyy-MM-dd HH:mm:ss";
    public final static String    zyFormat             = "yyyy/MM/dd HH:mm:ss";
    public final static String    noSecondFormat       = "yyyy-MM-dd HH:mm";
    public final static String    alipayFormat         = "yyyy/MM/dd";
    public final static long      ONE_DAY_SECONDS      = 86400;
    public final static long      ONE_DAY_MILL_SECONDS = 86400000;

    private static final String[] weekDayNames         = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

    /**
     * 获取星期中文描述
     * 
     * @param date
     * @return
     */
    public static String getWeekDayString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 0;
        }
        return weekDayNames[dayOfWeek];
    }

    public static DateFormat createNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        return df;
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static String formatDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        return dateFormat.format(date);
    }

    /**
     * yyyyMMdd
     * 
     * @param sDate
     * @return
     */
    public static Date parseDateNoTime(String sDate) {
        DateFormat dateFormat = new SimpleDateFormat(shortFormat);

        try {
            if ((sDate == null) || (sDate.length() < shortFormat.length())) {
                throw new ParseException("length too little", 0);
            }
            if (!StringUtils.isNumeric(sDate)) {
                throw new ParseException("not all digit", 0);
            }
            return dateFormat.parse(sDate);
        } catch (ParseException e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * yyyyMMdd 去除分隔符后格式化日期
     * 
     * @param sDate
     * @param delimit
     * @return
     * @throws ParseException
     */
    public static Date parseDateNoTimeWithDelimit(String sDate, String delimit) {
        sDate = sDate.replaceAll(delimit, "");
        return parseDateNoTime(sDate);
    }

    /**
     * yyyyMMddHHmmss
     * 
     * @param sDate
     * @return
     */
    public static Date parseDateLongFormat(String sDate) {
        DateFormat dateFormat = new SimpleDateFormat(longFormat);
        Date d = null;
        if ((sDate != null) && (sDate.length() == longFormat.length())) {
            try {
                d = dateFormat.parse(sDate);
            } catch (ParseException ex) {
                return null;
            }
        }
        return d;
    }

    /**
     * yyyyMMdd HHmmss
     * 
     * @param sDate
     * @return
     */
    public static Date parseDateNewFormat(String sDate) {
        DateFormat dateFormat = new SimpleDateFormat(newFormat);
        Date d = null;
        dateFormat.setLenient(false);
        if ((sDate != null) && (sDate.length() == newFormat.length())) {
            try {
                d = dateFormat.parse(sDate);
            } catch (ParseException ex) {
                return null;
            }
        }
        return d;
    }

    /**
     * 取得新的日期
     *
     * @param date1 日期
     * @param days 天数
     *
     * @return 新的日期
     */
    public static Date addDays(Date date1, long days) {
        return addSeconds(date1, days * ONE_DAY_SECONDS);
    }

    /**
     * 计算当前时间几小时之后的时间
     *
     * @param date
     * @param hours
     *
     * @return
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * 计算当前时间几分钟之后的时间
     *
     * @param date
     * @param minutes
     *
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * @param date1
     * @param secs
     *
     * @return
     */

    public static Date addSeconds(Date date1, long secs) {
        return new Date(date1.getTime() + (secs * 1000));
    }

    /**
     * minus date by days
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date minusDays(Date date, long days) {
        return minusHours(date, days * 24);
    }

    /**
     * minus date by hours
     * 
     * @param date
     * @param hours
     * @return
     */
    public static Date minusHours(Date date, long hours) {
        return minusMinutes(date, hours * 60);
    }

    /**
     * minus date by minutes
     * 
     * @param date
     * @param minutes
     * @return
     */
    public static Date minusMinutes(Date date, long minutes) {
        return minusSeconds(date, minutes * 60);
    }

    /**
     * minus date by secs
     * 
     * @param date
     * @param secs
     * @return
     */
    public static Date minusSeconds(Date date, long secs) {
        return new Date(date.getTime() - (secs * 1000));
    }

    /**
     * 判断输入的字符串是否为合法的小时
     *
     * @param hourStr
     *
     * @return true/false
     */
    public static boolean isValidHour(String hourStr) {
        if (!StringUtils.isEmpty(hourStr) && StringUtils.isNumeric(hourStr)) {
            int hour = new Integer(hourStr).intValue();
            if ((hour >= 0) && (hour <= 23)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断输入的字符串是否为合法的分或秒
     *
     * @param minuteStr
     *
     * @return true/false
     */
    public static boolean isValidMinuteOrSecond(String str) {
        if (!StringUtils.isEmpty(str) && StringUtils.isNumeric(str)) {
            int hour = new Integer(str).intValue();
            if ((hour >= 0) && (hour <= 59)) {
                return true;
            }
        }
        return false;
    }

    /**
     * yyyyMMdd
     * 
     * @param sDate yyyyMMdd
     * @return
     * @throws ParseException
     */
    public static String getTomorrowDateString(String sDate) throws ParseException {
        Date aDate = parseDateNoTime(sDate);
        aDate = addSeconds(aDate, ONE_DAY_SECONDS);
        return getDateString(aDate);
    }

    /**
     * yyyyMMdd
     * 
     * @param sDate yyyyMMdd
     * @return
     * @throws ParseException
     */
    public static String getYesterDayDateString(String sDate) throws ParseException {
        Date aDate = parseDateNoTime(sDate);
        aDate = addSeconds(aDate, -ONE_DAY_SECONDS);
        return getDateString(aDate);
    }

    /**
     * yyyyMMdd
     * 
     * @return
     */
    public static String getTodayString() {
        DateFormat dateFormat = createNewDateFormat(shortFormat);
        return formatDateString(new Date(), dateFormat);
    }

    /**
     * yyyyMMddHHmmss
     * 
     * @param date
     * @return
     */
    public static String getLongDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(longFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getNewFormatDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(newFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyy/MM/dd HH:mm:ss 
     * 
     * @param date
     * @return
     */
    public static String getZyFormatDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(zyFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * M/d
     * 
     * @param date
     * @return
     */
    public static String getSimpleFormatDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(simpleFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyyMMdd
     * 
     * @return 当天的时间格式化为"yyyyMMdd"
     */
    public static String getDateString(Date date) {
        DateFormat df = createNewDateFormat(shortFormat);
        return df.format(date);
    }

    /**
     * yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static String getWebDateString(Date date) {
        DateFormat dateFormat = createNewDateFormat(webFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyy-MM-dd
     * 
     * @param webDateStr
     * @return
     */
    public static Date parseDateWebString(String webDateStr) {
        DateFormat dateFormat = new SimpleDateFormat(webFormat);
        if ((webDateStr != null) && (webDateStr.length() == webFormat.length())) {
            try {
                return dateFormat.parse(webDateStr);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * yyyy年MM月dd日
     * 取得“X年X月X日”的日期格式
     *
     * @param date
     *
     * @return
     */
    public static String getChineseDateString(Date date) {
        DateFormat dateFormat = createNewDateFormat(chineseDtFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyy/MM/dd
     * 
     * @param date
     * @return
     */
    public static String getAlipayDateString(Date date) {
        DateFormat dateFormat = createNewDateFormat(alipayFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * HHmmss
     * 
     * @param date
     * @return
     */
    public static String getTimeString(Date date) {
        DateFormat dateFormat = createNewDateFormat(timeFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * yyyyMMdd
     * 
     * @param days
     * @return
     */
    public static String getBeforeDayString(int days) {
        Date date = new Date(System.currentTimeMillis() - (ONE_DAY_MILL_SECONDS * days));
        DateFormat dateFormat = createNewDateFormat(shortFormat);
        return formatDateString(date, dateFormat);
    }

    /**
     * 取得两个日期间隔秒数（日期1-日期2）
     *
     * @param one 日期1
     * @param two 日期2
     *
     * @return 间隔秒数
     */
    public static long getDiffSeconds(Date one, Date two) {
        return (one.getTime() - two.getTime()) / 1000;
    }

    public static long getDiffMinutes(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (60 * 1000);
    }

    /**
     * 取得两个日期的间隔天数
     *
     * @param one
     * @param two
     *
     * @return 间隔天数
     */
    public static long getDiffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * yyyyMMdd
     * 
     * @param dateString yyyyMMdd
     * @param days
     * @return
     */
    public static String getBeforeDayString(String dateString, int days) {
        Date date;
        DateFormat df = createNewDateFormat(shortFormat);
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            date = new Date();
        }
        date = new Date(date.getTime() - (ONE_DAY_MILL_SECONDS * days));
        return df.format(date);
    }

    /**
     * yyyyMMdd
     * 
     * @param strDate
     * @return
     */
    public static boolean isValidShortDateFormat(String strDate) {
        if (strDate.length() != shortFormat.length()) {
            return false;
        }
        DateFormat df = createNewDateFormat(shortFormat);

        try {
            df.parse(strDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * yyyyMMdd
     * 
     * @param strDate
     * @param delimiter
     * @return
     */
    public static boolean isValidShortDateFormat(String strDate, String delimiter) {
        String temp = strDate.replaceAll(delimiter, "");
        return isValidShortDateFormat(temp);
    }

    /**
     * 判断表示时间的字符是否为符合yyyyMMddHHmmss格式
     * 
     * @param strDate
     * @return
     */
    public static boolean isValidLongDateFormat(String strDate) {
        if (strDate.length() != longFormat.length()) {
            return false;
        }
        DateFormat df = createNewDateFormat(longFormat);

        try {
            df.parse(strDate);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * 判断表示时间的字符是否为符合yyyyMMddHHmmss格式
     * 
     * @param strDate
     * @param delimiter
     * @return
     */
    public static boolean isValidLongDateFormat(String strDate, String delimiter) {
        String temp = strDate.replaceAll(delimiter, "");
        return isValidLongDateFormat(temp);
    }

    /**
     * yyyyMMdd
     * @param strDate
     * @return
     */
    public static String getShortDateString(String strDate) {
        return getShortDateString(strDate, "-|/");
    }

    /**
     * yyyyMMdd
     * @param strDate
     * @param delimiter
     * @return
     */
    public static String getShortDateString(String strDate, String delimiter) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        String temp = strDate.replaceAll(delimiter, "");
        if (isValidShortDateFormat(temp)) {
            return temp;
        }
        return null;
    }

    /**
     * yyyyMMdd
     * @return
     */
    public static String getShortFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        Date dt = new Date();

        cal.setTime(dt);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        DateFormat df = createNewDateFormat(shortFormat);
        return df.format(cal.getTime());
    }

    /**
     * "yyyy-MM-dd"
     * @return
     */
    public static String getWebTodayString() {
        DateFormat df = createNewDateFormat(webFormat);
        return df.format(new Date());
    }

    /**
     * "yyyy-MM-dd"
     * @return
     */
    public static String getWebFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        Date dt = new Date();

        cal.setTime(dt);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        DateFormat df = createNewDateFormat(webFormat);
        return df.format(cal.getTime());
    }

    public static String convert(String dateString, DateFormat formatIn, DateFormat formatOut) {
        try {
            Date date = formatIn.parse(dateString);
            return formatOut.format(date);
        } catch (ParseException e) {
            logger.warn("convert() --- orign date error: " + dateString);
            return "";
        }
    }

    /**
     * "yyyyMMdd" to "yyyy-MM-dd"
     * @param dateString
     * @return
     */
    public static String convert2WebFormat(String dateString) {
        DateFormat df1 = createNewDateFormat(shortFormat);
        DateFormat df2 = createNewDateFormat(webFormat);
        return convert(dateString, df1, df2);
    }

    /**
     * "yyyyMMdd" to "yyyy年MM月dd日"
     * @param dateString
     * @return
     */
    public static String convert2ChineseDtFormat(String dateString) {
        DateFormat df1 = createNewDateFormat(shortFormat);
        DateFormat df2 = createNewDateFormat(chineseDtFormat);
        return convert(dateString, df1, df2);
    }

    /**
     * "yyyy-MM-dd" to yyyyMMdd
     * 
     * @param dateString
     * @return
     */
    public static String convertFromWebFormat(String dateString) {
        DateFormat df1 = createNewDateFormat(shortFormat);
        DateFormat df2 = createNewDateFormat(webFormat);
        return convert(dateString, df2, df1);
    }

    /**
     * yyyy-MM-dd
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static boolean webDateNotLessThan(String date1, String date2) {
        DateFormat df = createNewDateFormat(webFormat);
        return dateNotLessThan(date1, date2, df);
    }

    /**
     * @param date1
     * @param date2
     * @param dateWebFormat2
     *
     * @return
     */
    public static boolean dateNotLessThan(String date1, String date2, DateFormat format) {
        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);

            if (d1.before(d2)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            logger.debug("dateNotLessThan() --- ParseException(" + date1 + ", " + date2 + ")");
            return false;
        }
    }

    public static String getEmailDate(Date today) {
        String todayStr;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");

        todayStr = sdf.format(today);
        return todayStr;
    }

    public static String getSmsDate(Date today) {
        String todayStr;
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH:mm");

        todayStr = sdf.format(today);
        return todayStr;
    }

    public static String formatTimeRange(Date startDate, Date endDate, String format) {
        if ((endDate == null) || (startDate == null)) {
            return null;
        }

        String rt = null;
        long range = endDate.getTime() - startDate.getTime();
        long day = range / DateUtils.MILLIS_PER_DAY;
        long hour = (range % DateUtils.MILLIS_PER_DAY) / DateUtils.MILLIS_PER_HOUR;
        long minute = (range % DateUtils.MILLIS_PER_HOUR) / DateUtils.MILLIS_PER_MINUTE;

        if (range < 0) {
            day = 0;
            hour = 0;
            minute = 0;
        }

        rt = format.replaceAll("dd", String.valueOf(day));
        rt = rt.replaceAll("hh", String.valueOf(hour));
        rt = rt.replaceAll("mm", String.valueOf(minute));

        return rt;
    }

    public static String formatMonth(Date date) {
        if (date == null) {
            return null;
        }

        return new SimpleDateFormat(monthFormat).format(date);
    }

    /**
     * 获取系统日期的前一天日期，返回Date
     *
     * @return
     */
    public static Date getBeforeDate() {
        Date date = new Date();

        return new Date(date.getTime() - (ONE_DAY_MILL_SECONDS));
    }

    /**
     * 获得指定时间当天起点时间
     * 
     * @param date
     * @return
     */
    public static Date getDayBegin(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);

        String dateString = df.format(date);

        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static boolean isBeforeNow(Date date) {
        if (date == null)
            return false;
        return date.compareTo(new Date()) < 0;
    }

    /**
     * yyyy-MM-dd HH:mm
     * 
     * @param sDate
     * @return
     * @throws ParseException
     */
    public static Date parseNoSecondFormat(String sDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(noSecondFormat);

        if ((sDate == null) || (sDate.length() < noSecondFormat.length())) {
            throw new ParseException("length too little", 0);
        }
        return dateFormat.parse(sDate);
    }

    /**
     * yyyy-MM-dd HH:mm 
     * 
     * @param date
     * @return
     */
    public static String getNoSecondStr(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(noSecondFormat);
        return dateFormat.format(date);
    }

    /**
     * 比较日期，返回最大的日期值
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static Date max(Date date1, Date date2) {
        if (date1 == null) {
            return date2;
        }
        if (date2 == null) {
            return date1;
        }
        return date1.getTime() > date2.getTime() ? date1 : date2;
    }

    /**
     * 
     * @param time
     * @param birth
     * @return
     */
    public static int getAge(Date time, Date birth) {
        if (time == null) {
            throw new NullPointerException("time is null");
        }
        if (birth == null) {
            throw new NullPointerException("birth is null");
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(time.getTime());
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(birth.getTime());
        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
    }

    /**
     * 
     * @param birth
     * @return
     */
    public static int getAgeNow(Date birth) {
        return getAge(new Date(), birth);
    }

    public static Date getBirthNow(int age) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis());
        c1.add(Calendar.YEAR, -age);
        c1.set(Calendar.MONTH, 0);
        c1.set(Calendar.DAY_OF_MONTH, 1);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        return c1.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getFirstDayOfWeekFromMonday(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getLastDayOfWeekFromMonday(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getFirstDayOfWeekFromSunday(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getLastDayOfWeekFromSunday(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return cal.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getFirstDayOfMonth(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 
     * @param now
     * @return
     */
    public static Date getLastDayOfMonth(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 获取该天最后的时间
     * 
     * @param date
     * @return
     */
    public static Date getLastestTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取该天最开始的时间
     * 
     * @param date
     * @return
     */
    public static Date getFirstTimeOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getDuration(long durationSeconds) {
        int hours = (int) durationSeconds / (60 * 60);
        int leftSeconds = (int) durationSeconds % (60 * 60);
        int minutes = leftSeconds / 60;
        int seconds = leftSeconds % 60;

        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(hours);
        sBuffer.append("小时");
        sBuffer.append(minutes);
        sBuffer.append("分");
        sBuffer.append(seconds);
        sBuffer.append("秒");
        return sBuffer.toString();
    }
    
    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);

        df.setLenient(false);
        return df;
    }

    /**
     * pattern = yyyy-MM-dd
     * 
     * @param sDate
     * @return
     * @throws ParseException
     */
    public static Date parseWebString2Date(String sDate) throws ParseException {
        DateFormat dateFormat = getNewDateFormat(webFormat);

        if ((sDate == null) || (sDate.length() < webFormat.length())) {
            return null;
        }

        return dateFormat.parse(sDate);
    }
}
