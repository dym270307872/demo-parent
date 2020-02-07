package cn.dyaoming.demo.cacheredis.services;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.dyaoming.cache.interfaces.CacheBaseInterface;


@Service
public class RedisDemoService {

    @Autowired
    private CacheBaseInterface cacheDao;



    public String exists(int max) {

        return "键：" + max + "，exists方法验证结果:" + cacheDao.exists(max);
    }



    public String set(int max) {
        int random = new Random().nextInt(max);
        cacheDao.setCacheObjectData(max, random);
        return "键：" + max + "，set随机值：:" + random;
    }



    public String get(int max) {
        Object random = cacheDao.getCacheData(max);
        return "键：" + max + "，get缓存值：:" + random;
    }

}
