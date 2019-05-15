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



	@RequestMapping("default")
	public String defaultmethod(int num) {
		return demoService.defaultService(num);
	}



	@RequestMapping("public")
	public String publicmethod(int num) {
		return demoService.publicService(num);
	}



	@RequestMapping("user")
	public String usermethod(int num) {
		return demoService.userService(num);
	}



	@RequestMapping("business")
	public String businessmethod(int num) {
		return demoService.businessService(num);
	}

}
