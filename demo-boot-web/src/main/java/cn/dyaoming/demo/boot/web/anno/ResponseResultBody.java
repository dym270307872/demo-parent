package cn.dyaoming.demo.boot.web.anno;

import java.lang.annotation.*;


import org.springframework.web.bind.annotation.ResponseBody;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {
 
}