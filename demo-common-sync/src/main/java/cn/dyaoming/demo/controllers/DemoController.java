package cn.dyaoming.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.demo.services.DemoService;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    
    @RequestMapping("/tryLock")
    public String tryLock(String name) {     
        demoService.tryLock(name);
        return "success";
    }
}
