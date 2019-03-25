package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lijunsong
 * @date 2019/3/13 20:56
 * @since 1.0
 */
public class LRUMap extends LinkedHashMap {
    /**
     * 所以聪明的人们就发明了几种淘汰算法，下面列举下常见的三种FIFO,LRU,LFU（还有一些ARC,MRU感兴趣的可以自行搜索）:
     * <p>
     * FIFO:先进先出，在这种淘汰算法中，先进入缓存的会先被淘汰。这种可谓是最简单的了，
     * 但是会导致我们命中率很低。试想一下我们如果有个访问频率很高的数据是所有数据第一个访问的，
     * 而那些不是很高的是后面再访问的，那这样就会把我们的首个数据但是他的访问频率很高给挤出。
     * <p>
     * LRU:最近最少使用算法。在这种算法中避免了上面的问题，每次访问数据都会将其放在我们的队尾，
     * 如果需要淘汰数据，就只需要淘汰队首即可。但是这个依然有个问题，如果有个数据在1个小时的前59分钟访问了1万次
     * (可见这是个热点数据),再后一分钟没有访问这个数据，但是有其他的数据访问，就导致了我们这个热点数据被淘汰。
     * <p>
     * LFU:最近最少频率使用。在这种算法中又对上面进行了优化，利用额外的空间记录每个数据的使用频率，
     * 然后选出频率最低进行淘汰。这样就避免了LRU不能处理时间段的问题。
     * <p>
     * 上面列举了三种淘汰策略，对于这三种，实现成本是一个比一个高，同样的命中率也是一个比一个好。
     * 而我们一般来说选择的居中方案LRU即可。
     */
    private final int max;
    private Object lock;

    public LRUMap(int max, Object lock) {
        //无需扩容
        super((int) (max * 1.4f), 0.75f, true);
        this.max = max;
        this.lock = lock;
    }

    /**
     * 重写LinkedHashMapde removeEldestEntry方法即可，
     * 在put的时候判断，如果为true,就删除最老的
     * 设置的大小特意设置到max*1.4，在下面的removeEldestEntry方法中只需要size>max就淘汰，
     * 这样我们这个map永远也走不到扩容的逻辑了
     *
     * @return
     * @mpara eldest
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > max;
    }

    public Object getValue(Object key) {
        synchronized (lock) {
            return get(key);
        }
    }

    public void putValue(Object key, Object value) {
        synchronized (lock) {
            put(key, value);
        }
    }

    public boolean removeValue(Object key) {
        synchronized (lock) {
            return remove(key) != null;
        }
    }

    public boolean removeAll() {
        clear();
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * LRUMap,用来进行缓存数据的淘汰，但是有几个问题:
         *
         * 1,锁竞争严重，可以看见我的代码中，Lock是全局锁，在方法级别上面的，当调用量较大时，性能必然会比较低。
         *
         * 2,不支持过期时间
         *
         * 3,不支持自动刷新
         * 所以谷歌的大佬们对于这些问题，按捺不住了，发明了Guava cache
         */
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                //写后30ms过期
                .expireAfterWrite(30L, TimeUnit.MILLISECONDS)
                //访问后30ms过期
                .expireAfterAccess(30L, TimeUnit.MILLISECONDS)
                //20ms后flush
                .refreshAfterWrite(20L, TimeUnit.MILLISECONDS)
                //开启weakKey key当启动GC时，该缓存也被回收
                .weakKeys()
                .build(createCacheLoader());

        System.out.println(cache.get("hello"));
        cache.put("helloA", "我是helloA");
        System.out.println(cache.get("helloA"));
        cache.put("helloA", "更新helloA");
        System.out.println(cache.get("helloA"));
        /**
         * 相比于LRUMap多了两种过期时间，一个是写后多久过期expireAfterWrite，一个是读后多久过期expireAfterAccess。
         * guava cache中对于过期的Entry并没有马上过期(也就是并没有后台线程一直在扫)，
         * 而是通过进行读写操作的时候进行过期处理，这样做的好处是避免后台线程扫描的时候进行全局加锁。
         */
        Cache<String, String> cache1 = CacheBuilder.newBuilder()
                .maximumSize(100)
                //写后5ms过期
                .expireAfterWrite(5, TimeUnit.MILLISECONDS)
                //将分段最大设置为1，不然不会出现这个实验效果的
                .concurrencyLevel(1)
                .build();
        cache1.put("helloA", "我helloA");
        cache1.put("helloB", "我helloB");
        cache1.put("helloC", "我helloC");
        cache1.put("helloD", "我helloD");
        Thread.sleep(5);
        //写后5ms，上面四个过期
        System.out.println(cache1.size());
        cache1.put("helloE", "我helloE");
        System.out.println(cache1.size());

    }

    public static CacheLoader<String, String> createCacheLoader() {
        return new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return key;
            }
        };
    }
}
