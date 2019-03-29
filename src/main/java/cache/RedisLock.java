package cache;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author lijunsong
 * @date 2019/3/29 17:34
 * @since 1.0
 */
@Slf4j
public class RedisLock {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key   商品id
     * @param value 当前时间 + 超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        //其实是setnx命令，
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //避免死锁，并且只让一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (StringUtils.isNotEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValues = redisTemplate.opsForValue().getAndSet(key, value);
            /**
             * 只让一个线程拿到锁，
             * 如果旧的value和currentValue相等，只会又一个线程达成条件，因为第二个线程拿到oldValue已经和currentValue不一样
             */
            if (StringUtils.isNotEmpty(oldValues) && oldValues.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (StringUtils.isNotEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.info("redis 分布式锁 解锁异常：{}", e);
        }
    }
}
