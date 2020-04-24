package cn.dyaoming.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import cn.dyaoming.sync.interfaces.SyncLockInterface;
import redis.clients.jedis.Jedis;

public class RedisLockDao implements SyncLockInterface {

    @Autowired
    private RedisTemplate redisTemplate;
    
    @Autowired
    private Jedis jedis;
    
    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getLock(String key, String serial) {
        return (Boolean) redisTemplate.execute((RedisCallback) connection -> {

            long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());


            if (acquire) {
                return true;
            } else {

                byte[] value = connection.get(lock.getBytes());

                if (Objects.nonNull(value) && value.length > 0) {

                    long expireTime = Long.parseLong(new String(value));

                    if (expireTime < System.currentTimeMillis()) {
                        byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());

                        return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                    }
                }
            }
            return false;
        });
//        Long result = jedis.setnx(key,time, value);
        
        return false;
    }

    @Override
    public boolean releaseLock(String key, String serial) {
        // TODO Auto-generated method stub
        return false;
    }

}
