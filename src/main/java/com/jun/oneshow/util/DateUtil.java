package com.jun.oneshow.util;

import com.jun.oneshow.constants.CommonConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * 日期处理工具类
 * @author xiaoyi@sunWay.com
 *
 * @version v 0.1 DateUtil.java, 2018-1-8 
 */
public class DateUtil extends DateUtils {

    /** yyyyMMdd */
    public final static String SHORT_FORMAT           = "yyyyMMdd";

    /** yyyyMMddHHmmss */
    public final static String LONG_FORMAT            = "yyyyMMddHHmmss";

    /** yyyy-MM-dd */
    public final static String WEB_FORMAT             = "yyyy-MM-dd";
    
    /** yyyyMMdd */
    public final static String FILE_FORMAT			  = "yyyyMMdd";

    /** HHmmss */
    public final static String TIME_FORMAT            = "HHmmss";

    /** yyyyMM */
    public final static String MONTH_FORMAT           = "yyyyMM";

    /** yyyy年MM月dd日 */
    public final static String CHINA_FORMAT           = "yyyy年MM月dd日";

    /** yyyy年MM月dd日 */
    public final static String CHINA_LONG_FORMAT           = "yyyy年MM月dd日 HH:mm:ss";
    
    /** yyyy-MM-dd HH:mm:ss */
    public final static String LONG_WEB_FORMAT        = "yyyy-MM-dd HH:mm:ss";
    /*日志打印*/
    public final static String LOGGER_DATE_FORMAT     = "yyyy-MM-dd HH:mm:ss Z";

    /** yyyy-MM-dd HH:mm */
    public final static String LONG_WEB_FORMAT_NO_SEC = "yyyy-MM-dd HH:mm";
    
    public final static String YEAR_FORMAT = "yyyy";
    
    public final static int PRE_ONE = 1;
    
    public static String getDayBeginTime(String date){
    	return date.replace(CommonConstants.REGX_MINUS, "") + "000000";
    }
    
    public static String getDayEndTime(String date){
    	return date.replace(CommonConstants.REGX_MINUS, "") + "235959";
    }
    /**
     * @description: 返回tmx文件条目所需时间格式
     * @return:String
     * @param date
     * @return
     */
    public static String getTmxDateFormat(Date date){
    	String stringYear = DateUtil.format(date, DateUtil.FILE_FORMAT);
    	String stringHour = DateUtil.format(date, DateUtil.TIME_FORMAT);
    	return stringYear+"T"+stringHour+"Z";
    }
    /**
     *  
     * 
     * @param start
     * @param end
     * @return
     */
    public static long getDiffSeconds(Date start, Date end) {
        return (end.getTime() - start.getTime()) / 1000L;
    }

    /**
     * 日期对象解析成日期字符串基础方法，可以据此封装出多种便捷的方法直接使用
     * 
     * @param date
     *            待格式化的日期对象
     * @param format
     *            输出的格式
     * @return 格式化的字符串
     */
    public static String format(Date date, String format) {
        if (date == null || StringUtil.isBlank(format)) {
            return StringUtil.EMPTY_STRING;
        }
        return new DateTime(date).toString(format, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 格式化当前时间
     * 
     * @param format
     *            输出的格式
     * @return
     */
    public static String formatCurrent(String format) {
        if (StringUtil.isBlank(format)) {
            return StringUtil.EMPTY_STRING;
        }
        return new DateTime().toString(format, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 日期字符串解析成日期对象基础方法，可以在此封装出多种便捷的方法直接使用
     * 
     * @param dateStr
     *            日期字符串
     * @param format
     *            输入的格式
     * @return 日期对象
     * @throws ParseException
     */
    public static Date parse(String dateStr, String format) throws IllegalArgumentException {
        return DateTimeFormat.forPattern(format).withLocale(Locale.SIMPLIFIED_CHINESE)
            .parseDateTime(dateStr).toDate();
    }
    
    /**
     * 日期字符串解析成日期对象基础方法，可以在此封装出多种便捷的方法直接使用
     * 
     * @param dateStr
     *            日期字符串
     * @param format
     *            输入的格式
     * @return 日期对象
     * @throws ParseException
     */
    public static DateTime parseToDateTime(String dateStr, String format) throws IllegalArgumentException {
        return DateTimeFormat.forPattern(format).withLocale(Locale.SIMPLIFIED_CHINESE).parseDateTime(dateStr);
    }

    /**
     * 日期字符串格式化基础方法，可以在此封装出多种便捷的方法直接使用
     * 
     * @param dateStr
     *            日期字符串
     * @param formatIn
     *            输入的日期字符串的格式
     * @param formatOut
     *            输出日期字符串的格式
     * @return 已经格式化的字符串
     * @throws ParseException
     */
    public static String format(String dateStr, String formatIn, String formatOut)
                                                                                  throws IllegalArgumentException {
        Date date = parse(dateStr, formatIn);
        return format(date, formatOut);
    }

    /**
     * 把日期对象按照<code>yyyyMMdd</code>格式解析成字符串
     * 
     * @param date
     *            待格式化的日期对象
     * @return 格式化的字符串
     */
    public static String formatShort(Date date) {
        return format(date, SHORT_FORMAT);
    }

    /**
     * 把日期字符串按照<code>yyyyMMdd</code>格式，进行格式化
     * 
     * @param dateStr
     *            待格式化的日期字符串
     * @param formatIn
     *            输入的日期字符串的格式
     * @return 格式化的字符串
     */
    public static String formatShort(String dateStr, String formatIn)
                                                                     throws IllegalArgumentException {
        return format(dateStr, formatIn, SHORT_FORMAT);
    }

    /**
     * 把日期对象按照<code>yyyy-MM-dd</code>格式解析成字符串
     * 
     * @param date
     *            待格式化的日期对象
     * @return 格式化的字符串
     */
    public static String formatWeb(Date date) {
        return format(date, WEB_FORMAT);
    }

    /**
     * 把日期字符串按照<code>yyyy-MM-dd</code>格式，进行格式化
     * 
     * @param dateStr
     *            待格式化的日期字符串
     * @param formatIn
     *            输入的日期字符串的格式
     * @return 格式化的字符串
     * @throws ParseException
     */
    public static String formatWeb(String dateStr, String formatIn) throws IllegalArgumentException {
        return format(dateStr, formatIn, WEB_FORMAT);
    }

    /**
     * 把日期对象按照<code>yyyyMM</code>格式解析成字符串
     * 
     * @param date
     *            待格式化的日期对象
     * @return 格式化的字符串
     */
    public static String formatMonth(Date date) {

        return format(date, MONTH_FORMAT);
    }

    /**
     * 把日期对象按照<code>HHmmss</code>格式解析成字符串
     * 
     * @param date
     *            待格式化的日期对象
     * @return 格式化的字符串
     */
    public static String formatTime(Date date) {
        return format(date, TIME_FORMAT);
    }

    /**
     * 获取yyyyMMddHHmmss+n位随机数格式的时间戳
     * 
     * @param n
     *            随机数位数
     * @return
     */
    public static String getTimestamp(int n) {
        return formatCurrent(LONG_FORMAT) + RandomStringUtils.randomNumeric(n);
    }

    /**
     * 根据日期格式返回昨日日期
     * 
     * @param format
     * @return
     */
    public static String getYesterdayDate(String format) {
        return format(DateTime.now().minusDays(1).toDate(), format);
    }

    /**
     * 根据日期格式返回一周以前的日期
     * 
     * @param format
     * @return
     */
    public static String getLastWeekDate(String format) {
        return format(DateTime.now().minusDays(7).toDate(), format);
    }
    /**
     * @description: 根据日期格式返回n小时以前的日期
     * @return:String
     * @param format
     * @param n
     * @return
     */
    public static String getLastNHoursDate(String format, int n){
    	return format(DateTime.now().minusHours(n).toDate(), format);
    }
    /**
     * 返回输入日期的N月之后的时间
     * @param format
     * @param n
     * @return
     */
    public static String getNextNMonthsDate(String timeString, String format, int n){
    	if(StringUtil.isEmpty(timeString)){
    		return format(DateTime.now().plusMonths(n).toDate(), format);
    	} else {
    		return format(DateUtil.parseToDateTime(timeString, DateUtil.LONG_FORMAT).plusMonths(n).toDate(), format);
    	}
    }
    
    /**
     * @description:	返回输入日期的N月之前的时间
     * @return:String
     * @param timeString
     * @param format
     * @param n
     * @return
     */
    public static String getPreNMonthsDate(String timeString, String format, int n){
    	if(StringUtil.isEmpty(timeString)){
    		return format(DateTime.now().minusMonths(n).toDate(), format);
    	} else {
    		return format(DateUtil.parseToDateTime(timeString, DateUtil.LONG_FORMAT).minusMonths(n).toDate(), format);
    	}
    }
    
    /**
     * @description:生成指定格式的当前日期
     * @return:Date
     * @param format
     * @return
     */
    public static Date getCurrentDate(String format){
    	return DateUtil.parse(formatCurrent(format), format);
    }
    
    public static String getCurrentDateString(String format){
    	return DateUtil.format(new Date(), format);
    }
    
    public static String parse(Long time, String format) {
    	//
    	
    	SimpleDateFormat dateFormat =  new SimpleDateFormat(format);
    	dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); 
    	String dateStr = dateFormat.format(time);
    	
    	return dateStr;
    }
    
    /**
     * 将字符串转化为日期
     * @param date
     * @return
     */
    public static Date parseToDate(String date) {
    	try {
    		return parse(date, DateUtil.SHORT_FORMAT);
		} catch (Exception e) {
			
		}
    	try {
    		return parse(date, DateUtil.LONG_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.LONG_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.WEB_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.TIME_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.MONTH_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.CHINA_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, DateUtil.CHINA_LONG_FORMAT);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, "yyyy/MM/dd");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	try {
    		return parse(date, "yyyy");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
    
    public static Long ParseToLong(String dateStr) {
    	try {
    		Date date = parseToDate(dateStr);
    		return date.getTime();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
    
    public static String parseToData(long longData, String dateFormat) {
    	Date date = new Date(longData);
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	String year = String.valueOf(calendar.get(Calendar.YEAR));
    	return year;
    }
   
    
//    public static void main(String[] args) {
//		long d = -284025600000l;
//		String year =parse(d, "yyyy");
//		System.out.println(year);
//		
//		Date date = DateUtil.parse(year, "yyyy");
//		System.out.println(date.getTime());
//	}
    
}
