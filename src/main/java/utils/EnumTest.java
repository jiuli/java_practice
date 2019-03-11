package utils;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author lijunsong
 * @date 2019/3/8 16:22
 * @since 1.0
 */
public class EnumTest {
    public static void main(String[] args) {
        /**
         * EnumMap对Enum添加说明信息
         * EnumSet是Java枚举类型的泛型容器，
         * Java既然有了SortedSet、TreeSet、HashSet等容器，
         * 为何还要多一个EnumSet<T>呢？答案肯定是EnumSet有一定的特性，举个例子，EnumSet的速度很快
         */
        //是EnumMap对Enum添加说明信息
        EnumMap enumMap = new EnumMap(DayEnum.class);
        enumMap.put(DayEnum.MONDAY, "工作工作");
        enumMap.put(DayEnum.TUESDAY, "工作工作");
        enumMap.put(DayEnum.WEDNESDAY, "工作工作");
        enumMap.put(DayEnum.THURSDAY, "工作工作");
        enumMap.put(DayEnum.FRIDAY, "工作工作");
        enumMap.put(DayEnum.SATURDAY, "放假放假");
        enumMap.put(DayEnum.SUNDAY, "放假放假");
        System.out.println(enumMap);
        System.out.println(enumMap.get(DayEnum.FRIDAY));

        /**
         * EnumSet提供更快速的对Enum进行数组形式的操作
         * add方法实际只是对长整型数据element做了一个操作，也就是说EnumSet实际上将枚举值保存在一个长整型数据上
         * 元素个数没超过64个，返回RegularEnumSet
         * 超过64个了就用JumboEnumSet
         */
        Set<DayEnum> enumSet = EnumSet.noneOf(DayEnum.class);
        System.out.println(enumSet);
        enumSet.add(DayEnum.SATURDAY);
        enumSet.add(DayEnum.MONDAY);
        System.out.println(enumSet);
        
    }
}
