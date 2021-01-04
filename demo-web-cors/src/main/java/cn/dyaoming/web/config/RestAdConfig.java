package cn.dyaoming.web.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

import cn.dyaoming.web.advices.BaseResponseBodyAdvice;

@ControllerAdvice
public class RestAdConfig extends BaseResponseBodyAdvice{

}
