package cn.dyaoming.demo.cacheredis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.demo.cacheredis.services.RedisCacheService;

@RestController
@RequestMapping("redisCache")
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCache;
    
    @RequestMapping("defaultCache")
    public String defaultCache(int max) {
        return redisCache.defaultCache(max);
    }
    @RequestMapping("autoCache")
    public String autoCache(int max) {
        return redisCache.autoCache(max);
    }
    @RequestMapping("publicCache")
    public String publicCache(int max) {
        return redisCache.publicCache(max);
    }
    @RequestMapping("businessCache")
    public String businessCache(int max) {
        return redisCache.businessCache(max);
    }
}
