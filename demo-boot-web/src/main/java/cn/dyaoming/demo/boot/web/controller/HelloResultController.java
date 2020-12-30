package cn.dyaoming.demo.boot.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import cn.dyaoming.demo.boot.web.anno.ResponseResultBody;
import cn.dyaoming.demo.boot.web.model.Result;

@RestController
@RequestMapping("/helloResult")
//@ResponseResultBody
public class HelloResultController {
 
    private static final HashMap<String, Object> INFO;
 
    static {
        INFO = new HashMap<String, Object>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }
 
    @GetMapping("hello")
    public HashMap<String, Object> hello() {
        return INFO;
    }
 
    /** 测试重复包裹 */
    @GetMapping("result")
    public Result<Map<String, Object>> helloResult() {
        return Result.success(INFO);
    }
 
    /** 测试重复包裹 */
    @GetMapping("string")
    public String string() {
        return "success";
    }
    
    
    @GetMapping("list")
    public List list() {
        return Arrays.asList(INFO);
    }
    
    
    @GetMapping("int")
    public Integer inted() {
        return 0;
    }
    
    
    @GetMapping("helloError")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }
 
//    @GetMapping("helloMyError")
//    public HashMap<String, Object> helloMyError() throws Exception {
//        throw new ResultException();
//    }
}