package cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lijunsong
 * @date 2019/2/28 19:58
 * @since 1.0
 */
public class TestCaffeine {
    /**
     * 缓存进化史
     * 1，在流量不大的时候，查数据库或者读取文件是最为方便。
     * 2，当我们应用有一定流量之后或者查询数据库特别频繁，这个时候就可以祭出我们的java中自带的HashMap或者ConcurrentHashMap。
     * 但是这样做就有个问题HashMap无法进行数据淘汰，内存会无限制的增长，所以hashMap很快也被淘汰了。
     * 3,在caffeine所有的数据都在ConcurrentHashMap中，这个和guava cache不同，guava cache是自己实现了个类似ConcurrentHashMap的结构
     */
    private ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    private HashMap<String, String> hashMap = new HashMap();
    private CustomerMapper customerMapper;

    public String getCustomer(String name) {
        String customer = hashMap.get(name);
        if (customer == null) {
//            customer = customerMapper.get(name);
            hashMap.put(name, customer);
        }
        return customer;
    }


    public static void main(String[] args) {
        /**
         * 在caffeine中有三个记录引用的LRU队列:
         *  1, 所有的新数据都会进入Eden。
         *  2,Eden满了，淘汰进入Probation。
         *  3, 如果在Probation中访问了其中某个数据，则这个数据升级为Protected。
         *  4,如果Protected满了又会继续降级为Probation。
         */
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        cache.put("hello", "hello");
    }
}
