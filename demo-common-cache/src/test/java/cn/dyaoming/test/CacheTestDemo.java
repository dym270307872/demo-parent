package cn.dyaoming.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dyaoming.demo.services.DemoService;


public class CacheTestDemo extends BaseJunit {

	@Autowired
	private DemoService demoService;



	@Test
	public void run() {
		System.out.println("随机数：" + demoService.publicService(100));
	}
}
