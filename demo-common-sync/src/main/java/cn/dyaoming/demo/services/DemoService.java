package cn.dyaoming.demo.services;

import org.springframework.stereotype.Service;

import cn.dyaoming.sync.annotations.SyncLock;

@Service
public class DemoService {

    @SyncLock
    public void tryLock(String name) {
        System.out.println(name + ":我获取到了锁！");
    }
    
}
