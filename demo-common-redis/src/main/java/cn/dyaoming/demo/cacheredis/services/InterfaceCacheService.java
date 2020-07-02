package cn.dyaoming.demo.cacheredis.services;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface InterfaceCacheService {

    
    @Cacheable("default")
    public String defaultCache(int max);
    
    @Cacheable("auto#60#false#10")
    public String autoCache(int max);
    
    @Cacheable("publicInfo")
    public String publicCache(int max);
    
    @Cacheable("businessInfo")
    public String businessCache(int max);
    
    @CacheEvict(value="businessInfo",key="'cn.dyaoming.demo.cacheredis.services.RedisCacheService.businessCache('+#max+')'")
    public void flushdb(int max);
}
