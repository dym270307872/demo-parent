package cn.dyaoming.demo.cacheredis.controllers;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.demo.cacheredis.services.RedisDemoService;


@RestController
@RequestMapping("redisDemo")
public class RedisDemoController {

    @Autowired
    private RedisDemoService redisDemo;



    @RequestMapping("exists")
    public String exists(String key) {
        return redisDemo.exists(key);
    }



    @RequestMapping("set")
    public String set(String key) {
        return redisDemo.set(key);
    }



    @RequestMapping("get")
    public String get(String key) {
        return redisDemo.get(key);
    }
    
    
    @RequestMapping("keys")
    public Collection<String> keys(String key){
        return redisDemo.getKeys(key);
    }
}
