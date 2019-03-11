package utils;

import org.apache.commons.codec.binary.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    static Pattern patternComma = Pattern.compile(",\\w*$");
    static Pattern patternPoint = Pattern.compile("\\.\\w*$");

    public static final String EMPTY = "";
    public static final String COMMA = ",";
    public static final String NORM_SPLIT = ".";

    public static List<String> getParentPath(String currentPath, String separator) {
        List<String> parentPaths = new LinkedList();
        Pattern pattern;
        //判断是否为'.' 或者 ',' 否则返回空
        if (StringUtils.equals(separator, NORM_SPLIT)) {
            pattern = patternPoint;
        } else if (StringUtils.equals(separator, COMMA)) {
            pattern = patternComma;
        } else {
            return parentPaths;
        }
        //循环path 每次把截取到的新path赋值 然后再次循环截取 直到没有匹配的值为止
        Matcher matcher = pattern.matcher(currentPath);
        while (matcher.find()) {
            String newCurrentPath = matcher.replaceAll(EMPTY);
            parentPaths.add(newCurrentPath);
            currentPath = newCurrentPath;
            matcher = pattern.matcher(currentPath);
        }
        return parentPaths;
    }

    /**
     * 作用正常排序：
     * [1.1, 1.1.3, 1.2, 1.11.3, 1.12.1, 1.12.3, 1.20.3, 2.1, 2.11.3]
     *
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

    /**
     * 得到所有父级和本身
     * 当前path = "1,12,1"，返回["1","1,12","1,12,1"]
     *
     * @param array
     * @return
     */
    public static List<String> getParentsAndSelf(Object[] array) {
        StringBuilder temp = new StringBuilder();
        List<String> value = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                temp.append(array[i]);
            } else {
                temp.append("," + array[i]);
            }
            value.add(temp.toString());
        }
        return value;
    }

    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder();
        System.out.println(strBuilder);
        String name = "测试008";
        String path = "1,12,1";
        System.out.println(getParentsAndSelf(path.split(COMMA)));
        String outLineNum1 = "1.12.1";
        System.out.println(getParentPath(outLineNum1, NORM_SPLIT));
        String outLineNum2 = "1.2";
        String outLineNum3 = "1.1.3";
        String outLineNum4 = "1.20.3";
        String outLineNum5 = "1.11.3";
        String outLineNum6 = "1.1";
        String outLineNum7 = "2.1";
        String outLineNum8 = "2.11.3";
        String outLineNum9 = "1.12.3";
        //无用
        String[] ss1 = outLineNum1.split(".");
        String[] ss2 = outLineNum1.split("[.]");
        //作用同上
        String[] ss3 = outLineNum1.split("\\.");
        List<String> outLineNums = new ArrayList(Arrays.asList(outLineNum1, outLineNum2, outLineNum3,
                outLineNum4, outLineNum5, outLineNum6, outLineNum7, outLineNum8, outLineNum9));

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
        System.out.println(str.replace("1.1", "1.2"));
        System.out.println(str);
        System.out.println(name.contains("-"));
        System.out.println(name.lastIndexOf('-'));
        System.out.println(outLineNum1.substring(2));
//        System.out.println(name.replace(name.substring(name.lastIndexOf('-'), name.length()), ""));
        System.out.println(taskName.replace(taskName.substring(taskName.lastIndexOf('-'), taskName.length()), ""));
    }
}
