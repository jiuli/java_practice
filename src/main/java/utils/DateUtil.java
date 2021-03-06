package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
//	private static Log log = LogFactory.getLog(DateUtil.class);

	/**
	 * timestamp格式转换 util格式
	 * 
	 * @param date
	 * @return
	 */
	public static Date changeTimestamp(Timestamp date) {
		String time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (null != date && !date.equals("")) {
			// 将Timestamp型时间转化成Date型
			Date d = new Date(date.getTime());
			return d;
		} else {
			return null;
		}

	}

	/**
	 * 字符串转化时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date formatStringToUtilDate(String str) {
		Date date = null;
		if (str == null || "".equals(str)) return null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
//			log.error(e.getMessage());
		}

		return date;
	}

	/**
	 * 字符串转化时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date formatStringToUtilDate_2(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");

		try {
			// date = sdf.parse(str);
			date = (Date) sdf.parseObject(str);
		} catch (ParseException e) {
//			log.error(e.getMessage());
		}

		return date;
	}

	/**
	 * 字符串转化时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date formatStringToDate(String str) {
		Date date = null;
		if (str == null || "".equals(str)) return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
//			log.error(e.getMessage());
		}

		return date;
	}

	/**
	 * 日期格式化 yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 日期格式化 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTimeTwo(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 日期格式化 yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	/**
	 * 得到当前的时间
	 * 
	 * @return utildate
	 */
	public static Date getNowUtilDate() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	/**
	 * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
	 * 
	 * @param time
	 * @return
	 */
	public static Integer StringToTimestamp(String time) {

		int times = 0;
		try {
			times = (int) ((Timestamp.valueOf(time).getTime()) / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (times == 0) {
			System.out.println("String转10位时间戳失败");
		}
		return times;

	}

	/**
	 * 10位int型的时间戳转换为String(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param time
	 * @return
	 */
	public static String timestampToString(Integer time) {
		// int转long时，先进行转型再进行计算，否则会是计算结束后在转型
		long temp = (long) time * 1000;
		Timestamp ts = new Timestamp(temp);
		String tsStr = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			// 方法一
			tsStr = dateFormat.format(ts);
			System.out.println(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tsStr;
	}

	/**
	 * 10位时间戳转Date
	 * 
	 * @param time
	 * @return
	 */
	public static Date TimestampToDate(Integer time) {
		long temp = (long) time * 1000;
		Timestamp ts = new Timestamp(temp);
		Date date = new Date();
		try {
			date = ts;
			// System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	 public static StringBuffer timeDifference(Date date_1,Date date_2){
	    	StringBuffer date_str = new StringBuffer();
	    	try{
	    		long l = date_1.getTime() - date_2.getTime();
	    		long day = l/(24*60*60*1000);
	    		long hour = l/(60*60*1000)-day*24;
	    		long min = ((l/(60*1000))-day*24*60-hour*60);
	    		long sec = (l/1000-day*24*60*60-hour*60*60-min*60);
	    		if(day > 0){
	    			date_str.append(day);
	    			date_str.append("天");
	    		}
	    		if(hour > 0){
	    			date_str.append(hour);
	    			date_str.append("小时");
	    		}
	    		date_str.append(min);
				date_str.append("分");
				date_str.append(sec);
				date_str.append("秒");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return date_str;
	    }
}
