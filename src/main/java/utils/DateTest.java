package utils;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {
	public static ZonedDateTime dateToZonedDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        /** calendar.get(Calendar.MONTH)比真实月份少了一个月,范围：0-11
         * */
        return  ZonedDateTime.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),0,0,0,0,ZoneId.of("Asia/Shanghai"));
    }
	
	public static LocalDate dateToLocalDate(Date date) {
        Date utilDate = new Date(date.getTime());
        Instant instant = utilDate.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }
	
	public static ZonedDateTime stringToZonedDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsed = LocalDate.parse(dateStr, formatter);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(parsed, LocalTime.MIDNIGHT, ZoneId.of("Asia/Shanghai"));
        return zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
    }
	//得到当前时间，只要年月日
	public static ZonedDateTime genCurrDate() {
		return dateToZonedDateTime(new Date());
    }

	public static void main(String[] args) {
		ZonedDateTime collectTime = ZonedDateTime.parse("2018-11-30T00:00:00+01:00");
		System.out.println(LocalDate.now().equals(LocalDate.of(collectTime.getYear(), 
				collectTime.getMonthValue(), collectTime.getDayOfMonth())));
		
		final Calendar calendar = Calendar.getInstance();
		System.out.println("spring cron 不支持 L，W，C");
		System.out.println("得到当前月天数和当前月总的天数");
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.getActualMaximum(Calendar.DATE));
        
		System.out.println(genCurrDate());
		ZonedDateTime date1 = ZonedDateTime.parse("2018-10-20T00:00:00+01:00");
		ZonedDateTime date3 = ZonedDateTime.parse("2018-10-20T00:00:00+01:00");
		ZonedDateTime date2 = ZonedDateTime.now();
		System.out.println(date1);
		System.out.println("dateTime: "+date1.toLocalDateTime().toString());
		System.out.println("date: "+date1.toLocalDate().toString());
		System.out.println(date2);
		System.out.println("得到当前时间，只要年月日");
		System.out.println(date2.truncatedTo(ChronoUnit.DAYS));
		
		System.out.println(date1.equals(date3));
		System.out.println(date1.isEqual(date3));
		System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));
		System.out.println(stringToZonedDateTime("2008-12-03"));
		System.out.println("Period 不能跨年计算");
		System.out.println(Period.between(date1.toLocalDate(), date2.toLocalDate()).getDays());
		System.out.println("Duration 能跨年计算");
		System.out.println(Duration.between(date1, date2).toDays());
		System.out.println(Duration.between(date2, date1).toDays());
		System.out.println("增加减少天数");
		System.out.println(date2.plusDays(1));
		System.out.println(date2.minusDays(1));
		System.out.println(Math.abs(-1));
		
		ZonedDateTime zoneDateTime = date1.plus(Period.ofDays(3));
		System.out.println("zoneDateTime 加上天数");
		System.out.println(zoneDateTime);
		System.out.println("ZoneDateTime转Date");
		System.out.println(Date.from(date2.toInstant()));
		System.out.println(date1.isBefore(date2));
		System.out.println(new Date(0).toInstant().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.systemDefault()));
		//BigDecimal
		System.out.println("BigDecimal计算");
		BigDecimal num1 = BigDecimal.ZERO;
		BigDecimal num2 = new BigDecimal(2.1);
		BigDecimal num3 = new BigDecimal(5);
		System.out.println("int,double,long,string转BigDecimal");
		int numInt = 2;
		System.out.println(new BigDecimal(numInt));
		long numLong = 2;
		System.out.println(new BigDecimal(numLong));
		Double num5 = 1.2D;
		System.out.println(new BigDecimal(num5));
		String num4 = "1.2";
		System.out.println(new BigDecimal(num4));
		System.out.println("BigDecimal除法");
		System.out.println(num1.divide(num2, 5, BigDecimal.ROUND_UP));
		System.out.println(num1.equals(BigDecimal.ZERO));
		num1.add(num2);
		num1.add(num2);
		List<BigDecimal> list = new ArrayList();
		list.add(num2);
		list.add(num3);
		for(BigDecimal num : list){ 
			num1 = num1.add(num);
		}
		System.out.println(num1);
		
		System.out.println("BigDecimal乘法");
		System.out.println(new BigDecimal(num4).multiply(num2));
		
		System.out.println("Date时间转换成ZoneDateTime");
		Date date = new Date();
		System.out.println(date);
		System.out.println(dateToZonedDateTime(date));
		
		System.out.println("LocalDate");
		Date date_1 = new Date("2018/9/10");
		LocalDate localDate = dateToLocalDate(new Date());
		System.out.println(localDate.until(dateToLocalDate(date_1), ChronoUnit.DAYS));
		
	}

}
