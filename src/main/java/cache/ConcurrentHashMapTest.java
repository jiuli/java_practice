package cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lijunsong
 * @date 2019/3/14 11:27
 * @since 1.0
 */
public class ConcurrentHashMapTest {
    private static ConcurrentHashMap<String, String> cacheMap = new ConcurrentHashMap<>();

    /**
     * 得到一个缓存Key
     *
     * @param account
     * @return
     */
    private static String getCacheKey(String account) {
        return Thread.currentThread().getId() + "-" + account;
    }

    private static String initCache(String key) {
        //一般是数据库数据预加载到缓存
        String value = "查询数据库数据";
        cacheMap.put(key, value);
        return value;
    }

    public static String getCache(String account) {
        String key = getCacheKey(account);
        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
        //没有时，进行数据缓存加载，并返回
        return initCache(key);
    }

    /**
     * 删除缓存信息
     *
     * @param account
     */
    public static void removeCache(String account) {
        cacheMap.remove(getCacheKey(account));
    }

    public static void main(String[] args) {
        /**
         * ConcurrentHashMap
         * 底层采用分段的数组+链表实现，线程安全
         * 通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读取到最新的值。)
         * Hashtable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术
         * 有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
         * 扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容
         *
         * ConcurrentHashMap融合了Hashtable和HashMap二者的优势。
         *
         *  HashTable是做了线程同步，HashMap未考虑同步。所以HashMap在单线程下效率较高，
         *  HashTable在多线程下同步操作能保证程序的正确性。  但是HashTable每次执行同步操作都需要锁住整个结构
         */
    }
}
