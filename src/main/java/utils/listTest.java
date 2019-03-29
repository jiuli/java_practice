package utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class listTest {
    public static final List<String> ORDER_ONE = new ArrayList<>(Arrays.asList("朱元璋", "朱棣"));
    public static final List<String> ORDER_two = new ArrayList<>(Arrays.asList("朱元璋", "朱棣", "朱元璋"));
    public static final List<String> sub1 = new ArrayList<>(Arrays.asList("朱元璋", "朱棣"));
    public static final List<String> sub2 = new ArrayList<>(Arrays.asList("朱元璋", "朱棣", "朱元璋", "朱棣"));
    public static final List<String> sub3 = new ArrayList<>(Arrays.asList("朱棣", "朱元璋"));

    public static void main(String[] args) {
//        SortedSet sortedSet = new SortedSet(){};
        HashSet hashSet = new HashSet();
        Map map11 = new HashMap();
        map11.put(1,"没有");
        System.out.println(map11.get(1));
        System.out.println(map11.get(11));
        System.out.println(ORDER_ONE.toString());
        List<String> newTaskNames = Arrays.asList("dfdfd".split(","));
        //Arrays.asList得到是static,oldTaskNames.remove()错误！
        //Iterator<String> oldTaskNames =  Arrays.asList("dfdfd".split(",")).iterator();
        Iterator<String> oldTaskNames =  new ArrayList(Arrays.asList("dfdfd".split(","))).iterator();
        for (String newTaskName : newTaskNames) {
            while (oldTaskNames.hasNext()) {
                String taskName = oldTaskNames.next();
                if(taskName.equals(newTaskName)) {
                    oldTaskNames.remove();
                }
            }
        }

        System.out.println(oldTaskNames.toString());
        /**
         * 实现多个对象中相同的字段值相加？最后得到一个对象
         */
        List<BaseDTO> baseDTOList = new ArrayList<>();
        System.out.println(baseDTOList.subList(0,baseDTOList.size()));
        LinkedList linkedList = new LinkedList();
        List one = null;
        List<String> two = new ArrayList<>();
        System.out.println(two.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList()));
        System.out.println(CollectionUtils.isEmpty(two));
        System.out.println(CollectionUtils.size(two));

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        System.out.println(map1.get("b"));
        //Guava 取代 list = new ArrayList<>();
        List initList = Lists.newArrayList();
        initList.add(1);
        initList.remove(0);
        /**
         * 使用Collections.singletonList（）方法[不可变列表]
         * Arrays.asList(something)允许Arrays.asList(something) 更改
         */
        List initList1 = Arrays.asList("12");
        List initList2 = Collections.singletonList("12");
//        initList1.add("23");  不支持add和remove方法
//        initList1.remove(0);
        initList1.set(0, "1234");
        System.out.println(initList1);
//        initList2.add("123"); 不支持add和remove方法

        System.out.println(sub1.remove("dfd"));
        System.out.println("删除多个，重复怎么删除，元素顺序是否影响删除");
        sub1.forEach(name -> sub2.remove(name));
//		System.out.println(sub2.removeAll(sub1));
        List<String> finalSub = new ArrayList<>();
        for (String str : sub2) {
            if (sub1.contains(str)) {
                sub1.remove(str);
            } else {
                finalSub.add(str);
            }
        }
        System.out.println(finalSub);
//		System.out.println(sub2.removeAll(sub3));
//		System.out.println(sub2);

        System.out.println(String.join(",", ORDER_ONE));
        System.out.println(ORDER_ONE.indexOf("11"));

        System.out.println("例子1 - 计算'朱元璋'出现的次数");
        System.out.println("朱元璋 : " + Collections.frequency(ORDER_two, "朱元璋"));
        System.out.println("朱元璋 : " + Collections.frequency(ORDER_two, "朱棣"));

        Map<String, String> map = new HashMap<>();
        map.put("name", "lijunsong");
        System.out.println(map.get("name"));
        System.out.println(map.get("project"));

        List<String> list = new ArrayList<>();
        list.add("11");
        List<String> list1 = new ArrayList<>();
        System.out.println(String.join(",", list1));

        System.out.println(list1.indexOf(11));
        System.out.println("list addAll empty list1");
        System.out.println(list.addAll(list1));
        System.out.println(list);

        System.out.println(list.subList(1, list.size()));

        List<String> allStudents = new ArrayList<>();
        List<String> boyStudents = new ArrayList<>();
        List<String> girlStudents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allStudents.add("name is " + i);
        }
        System.out.println(allStudents);
        for (int i = 0; i < 5; i++) {
            boyStudents.add("name is " + i);
        }
        boyStudents.add("name is 11");
        for (int i = 6; i < 10; i++) {
            girlStudents.add("name is " + i);
        }

        System.out.println("allStudents.size()------before-------------->" + allStudents.size());
        System.out.println("remove result : " + allStudents.removeAll(boyStudents));
        System.out.println("remove result : " + boyStudents.removeAll(girlStudents));
        System.out.println("allStudents.size()-------after-------------->" + allStudents.size());
        System.out.println(boyStudents);
        System.out.println(girlStudents);
        System.out.println(allStudents);
        allStudents.clear();
        System.out.println(allStudents.indexOf("name is 5"));
//		System.out.println("1".substring("1".indexOf(".")));
    }
}
