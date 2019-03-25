package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijunsong
 * @date 2019/3/18 17:06
 * @since 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", null);
        map.put("4", 4);
//        Integer integer = map.compute("3", (k, v) -> v + 1);
        //key不管存在与否，都会执行后面的函数，并保存到map中
        Integer integer1 = map.compute("4", (k, v) -> {
            if (v == null) {
                return 0;
            }
            return v + 1;
        });

        //当key存在，value不为空则返回值，不执行函数；value为空，执行函数并保存值到map中
        //当key不存在则执行函数并保存到map中
        Integer integer2 = map.computeIfAbsent("3", key -> new Integer(4));
        Integer integer3 = map.computeIfAbsent("4", key -> new Integer(6));
        Integer integer4 = map.computeIfAbsent("5", key -> new Integer(5));
        System.out.println(map.get("1"));
    }
}
