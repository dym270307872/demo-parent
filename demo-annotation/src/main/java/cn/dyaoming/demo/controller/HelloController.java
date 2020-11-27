package cn.dyaoming.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.dyaoming.demo.annotation.RestController;

import cn.dyaoming.demo.model.RestResult;
import cn.dyaoming.demo.supper.BaseController;

@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {

	@GetMapping("/hello")
	public String hello() {
		return "success";
	}

	@GetMapping("/result")
	public RestResult helloResult() {
		return RestResult.success();
	}
}