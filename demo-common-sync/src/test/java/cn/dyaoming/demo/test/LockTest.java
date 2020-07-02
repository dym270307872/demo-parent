package cn.dyaoming.demo.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dyaoming.sync.interfaces.SyncLockInterface;


public class LockTest extends BaseJunit {

    @Autowired
    private SyncLockInterface redisLock;



    @Test
    public void runLock() {
        String key = "mykey";
        String serial = "00123456";

        if (redisLock.tryLock(key, serial, 2L)) {
            System.out.println("获得锁");

        } else {
            System.out.println("未获得锁");
        }

    }
}
