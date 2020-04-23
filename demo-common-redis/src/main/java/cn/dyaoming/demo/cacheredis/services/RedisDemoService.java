package cn.dyaoming.demo.cacheredis.services;


import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.dyaoming.cache.interfaces.CacheBaseInterface;
import cn.dyaoming.cache.interfaces.CacheInterface;


@Service
public class RedisDemoService {

    @Autowired
    private CacheInterface cacheDao;



    public String exists(String key) {

        return "键：" + key + "，exists方法验证结果:" + cacheDao.exists(key);
    }



    public String set(String key) {
        int random = new Random().nextInt(100);
        cacheDao.setCacheObjectData(key, random);
        return "键：" + key + "，set随机值：:" + random;
    }



    public String get(String key) {
        Object random = cacheDao.getCacheData(key);
        return "键：" + key + "，get缓存值：:" + random;
    }

    
    public Collection<String> getKeys(String key) {
        return cacheDao.getKeys(key);
    }
    
}
