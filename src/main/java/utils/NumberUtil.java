package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class NumberUtil {
	public static boolean isZero(BigDecimal value) {
        return BigDecimal.ZERO.compareTo(value) == 0;
    }
	 public static String parseToPercentage(double num, int miniFractionDigits) {
	        NumberFormat numberFormat = NumberFormat.getPercentInstance();
	        numberFormat.setMinimumFractionDigits(miniFractionDigits);
	        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
	        return numberFormat.format(num);
	    }
	public static void main(String[] args) {
		BigDecimal a = BigDecimal.ZERO;
		BigDecimal b = new BigDecimal("0.00");
		BigDecimal c = new BigDecimal("1");
		BigDecimal d = new BigDecimal("2");
		System.out.println(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3),3));
//		System.out.println(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3)));
		System.out.println(c.multiply(new BigDecimal("78").divide(new BigDecimal("100"))));
		
		System.out.println(a.equals(b));
		System.out.println("使用compareTo判断BigDecimal类型变量是否为零，equals比较不了0,0.0,0.00");
		System.out.println(a.compareTo(BigDecimal.ZERO));
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(c));
		System.out.println(d.compareTo(c));
		System.out.println(NumberUtil.isZero(b));
		System.out.println(NumberUtil.isZero(c));
		
		NumberFormat num = NumberFormat.getPercentInstance();
        num.setMinimumFractionDigits(2);
        num.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("百分比");
        System.out.println(num.format(1.11D));
        System.out.println(parseToPercentage(1.11D,2));
        Integer int1 = 11;
        Integer int2 = 11;
        System.out.println(int1.equals(int2));
        String[] ids = "".split(":");
        System.out.println(ids);
        for (String id : ids) {
        	System.out.println(id);
        }
      
        
	}
}
