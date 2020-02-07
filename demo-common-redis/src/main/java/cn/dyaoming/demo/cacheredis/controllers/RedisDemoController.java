package cn.dyaoming.demo.cacheredis.controllers;


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
    public String exists(int max) {
        return redisDemo.exists(max);
    }



    @RequestMapping("set")
    public String set(int max) {
        return redisDemo.set(max);
    }



    @RequestMapping("get")
    public String get(int max) {
        return redisDemo.get(max);
    }
}
