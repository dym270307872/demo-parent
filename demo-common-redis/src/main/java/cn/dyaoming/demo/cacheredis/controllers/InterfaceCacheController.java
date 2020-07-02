package cn.dyaoming.demo.cacheredis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.demo.cacheredis.services.InterfaceCacheService;
import cn.dyaoming.demo.cacheredis.services.RedisCacheService;

@RestController
@RequestMapping("interfaceCache")
public class InterfaceCacheController {

    @Autowired
    private InterfaceCacheService interfaceCache;
    
    @RequestMapping("defaultCache")
    public String defaultCache(int max) {
        return interfaceCache.defaultCache(max);
    }
    @RequestMapping("autoCache")
    public String autoCache(int max) {
        return interfaceCache.autoCache(max);
    }
    @RequestMapping("publicCache")
    public String publicCache(int max) {
        return interfaceCache.publicCache(max);
    }
    @RequestMapping("businessCache")
    public String businessCache(int max) {
        return interfaceCache.businessCache(max);
    }
    
    
    @RequestMapping("flushdb")
    public String flushdb(int max) {
        interfaceCache.flushdb(max);
        return "success";
    }
}
