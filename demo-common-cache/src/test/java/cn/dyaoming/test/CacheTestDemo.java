package cn.dyaoming.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dyaoming.demo.services.DemoService;


public class CacheTestDemo extends BaseJunit {

	@Autowired
	private DemoService demoService;



	@Test
	public void run() {
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(100));
		System.out.println(demoService.businessService(1000));
		System.out.println(demoService.businessService(1000));
		System.out.println(demoService.businessService(1000));
		System.out.println(demoService.businessService(1000));
		System.out.println(demoService.businessService(1200));
		System.out.println(demoService.businessService(1200));
		demoService.chear(1200);
	}
	
	
	
}
