package cn.dyaoming.demo.cacheredis.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service("interfaceCache")
public class InterfaceCacheImpl implements InterfaceCacheService {

    public String defaultCache(int max) {
        return "default类型随机数:"+new Random().nextInt(max);
    }
    
    public String autoCache(int max) {
        return "auto类型随机数:"+new Random().nextInt(max);
    }
    
    public String publicCache(int max) {
        return "publicInfo类型随机数:"+new Random().nextInt(max);
    }
    
    public String businessCache(int max) {
        return "businessInfo类型随机数:"+new Random().nextInt(max);
    }
    
    public void flushdb(int max) {
        
    }

}
