package cn.dyaoming.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.errors.AppAccessException;
import cn.dyaoming.errors.AppBusyException;
import cn.dyaoming.errors.AppMessageException;
import cn.dyaoming.errors.AppParameterValidationException;
import cn.dyaoming.errors.BaseRunTimeException;
import cn.dyaoming.models.BaseRestModel;

@RestController
@RequestMapping("/demo")
public class DemoController {

    
    @RequestMapping("/tellMeYourName")
    public String tellMeYourName() {
        return "My name is dyaoming";
    }
    
    
    @RequestMapping("/tellMeYourFamily")
    public Map<String, Object> tellMeYourFamily(){
        Map<String, Object> reMap = new HashMap<>(16);
        reMap.put("mother", "妈妈");
        reMap.put("father", "爸爸");
        return reMap;
    }
    
    
    @RequestMapping("/sayHello")
    public BaseRestModel sayHello(String name){
        return BaseRestModel.success("hello " + name);
    }
    
    
    @RequestMapping("/throwException")
    public BaseRestModel throwExceptions(String type){
        BaseRunTimeException e;
        switch(type) {
            case "access":
                e = AppAccessException.create("未获得授权");
                break;
            case "busy":
                e = AppBusyException.create("业务繁忙");
                break;
            case "message":
                e = AppMessageException.create("业务逻辑错误");
                break;
            case "parameter":
                e = AppParameterValidationException.create("8901","参数效验错误");
                break;
            default:
                e = null;
                break;
        }
        throw e;
    }
}
