package cn.dyaoming.demo.services;


import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class DemoService {

	@Cacheable("default")
	public String defaultService(int num) {
		return "默认缓存方法返回随机值:" + new Random().nextInt(num);
	}



	@Cacheable("publicInfo")
	public String publicService(int num) {
		return "公共缓存方法返回随机值:" + new Random().nextInt(num);
	}



	@Cacheable("userInfo")
	public String userService(int num) {
		return "用户缓存方法返回随机值:" + new Random().nextInt(num);
	}



	@Cacheable("businessInfo")
	public String businessService(int num) {
		return "业务缓存方法返回随机值:" + new Random().nextInt(num);
	}

}
