package cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lijunsong
 * @date 2019/2/28 19:58
 * @since 1.0
 */
public class TestCaffeine {
    /**
     * 缓存进化史
     */
    private HashMap<String,String> hashMap = new HashMap();
    private CustomerMapper customerMapper;
    public String getCustomer(String name){
        String customer = hashMap.get(name);
        if ( customer == null){
//            customer = customerMapper.get(name);
            hashMap.put(name,customer);
        }
        return customer;
    }


    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1,TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        cache.put("hello","hello");
    }
}
