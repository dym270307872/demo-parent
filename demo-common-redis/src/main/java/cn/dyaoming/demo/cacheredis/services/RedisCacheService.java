package cn.dyaoming.demo.cacheredis.services;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable("default")
    public String defaultCache(int max) {
        return "default类型随机数:"+new Random().nextInt(max);
    }
    
    @Cacheable("auto#60#false#10")
    public String autoCache(int max) {
        return "auto类型随机数:"+new Random().nextInt(max);
    }
    
    @Cacheable("publicInfo")
    public String publicCache(int max) {
        return "publicInfo类型随机数:"+new Random().nextInt(max);
    }
    
    @Cacheable("businessInfo")
    public String businessCache(int max) {
        return "businessInfo类型随机数:"+new Random().nextInt(max);
    }
}
