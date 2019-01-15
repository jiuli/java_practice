package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringTest {
	/**
	 * 
     *  作用正常排序：
     * [1.1, 1.1.3, 1.2, 1.11.3, 1.12.1, 1.12.3, 1.20.3, 2.1, 2.11.3]
	 * @param outLineNumOne
	 * @param outLineNumTwo
	 * @return
	 */
	public static int compareOutLineNum(String outLineNumOne, String outLineNumTwo) {
        if (outLineNumOne == null || outLineNumTwo == null) {
            return 0;
        }
        String[] subs1 = outLineNumOne.split("\\.");
        String[] subs2 = outLineNumTwo.split("\\.");
        if (subs1 == null || subs1.length == 0) {
            return 0;
        }

        if (subs2 == null || subs2.length == 0) {
            return 0;
        }

        int lth1 = subs1.length;
        int lth2 = subs2.length;
        int minlth = lth1 < lth2 ? lth1 : lth2;
        for (int i = 0; i < minlth; i++) {
            int n1 = Integer.parseInt(subs1[i]);
            int n2 = Integer.parseInt(subs2[i]);
            int icomp = n1 - n2;
            if (icomp != 0) {
                return icomp;
            }
        }
        return lth1 - lth2;
    }
	 public static List<String> sortTasksByOutlineNum(List<String> outLineNums) {
	        if (outLineNums == null || outLineNums.size() < 2) {
	            return outLineNums;
	        }
	        outLineNums.sort((Comparator<String>) (taskOne, taskTwo) -> StringTest.compareOutLineNum(taskOne, taskTwo));
	        return outLineNums;
	    }
	public static void main(String[] args) {
		String name = "测试008";
		String outLineNum1 = "1.12.1";
		String outLineNum2 = "1.2";
		String outLineNum3 = "1.1.3";
		String outLineNum4 = "1.20.3";
		String outLineNum5 = "1.11.3";
		String outLineNum6 = "1.1";
		String outLineNum7 = "2.1";
		String outLineNum8 = "2.11.3";
		String outLineNum9 = "1.12.3";
		String[] ss1 = outLineNum1.split(".");//无用
		String[] ss2 = outLineNum1.split("[.]"); 
		String[] ss3 = outLineNum1.split("\\.");//作用同上
		List<String> outLineNums = new ArrayList(Arrays.asList(outLineNum1,outLineNum2,outLineNum3,
				outLineNum4,outLineNum5,outLineNum6,outLineNum7,outLineNum8,outLineNum9));
		
		outLineNums.sort((Comparator<String>) (taskOne, taskTwo) -> StringTest.compareOutLineNum(taskOne, taskTwo));
		
		System.out.println(outLineNums);
		
		System.out.println(ss1.toString());
		
		String taskName = "测试008-结构主体施工-分区";
		System.out.println(name.lastIndexOf('-'));
		//name没有-,substring报错
//		System.out.println(name.replace(name.substring(name.lastIndexOf('-'), name.length()), ""));
		System.out.println("1".startsWith("1.1"));
		System.out.println("1.2.1".startsWith("1.1"));
		String str = "1.1.1";
		System.out.println(str.replace("1.1","1.2"));
		System.out.println(str);
		System.out.println(name.contains("-"));
		System.out.println(name.lastIndexOf('-'));
		System.out.println(outLineNum1.substring(2));
		System.out.println(name.replace(name.substring(name.lastIndexOf('-'), name.length()), ""));
		System.out.println(taskName.replace(taskName.substring(taskName.lastIndexOf('-'), taskName.length()), ""));
	}
}
