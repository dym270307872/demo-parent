package cn.dyaoming.test;


import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dyaoming.cache.interfaces.CacheBaseInterface;
import cn.dyaoming.cache.interfaces.CacheBatchInterface;
import cn.dyaoming.cache.interfaces.CacheInterface;


public class RegexDemo extends BaseJunit {

	@Autowired
	private CacheInterface cacheDao;



	@Test
	public void demo1() {
		Collection<String> l =cacheDao.getKeys("cache:businessInfo:*1200*");
//		cache:businessInfo:cn.dyaoming.demo.services.DemoService.businessService[1200]
		l.stream().forEach(p->{
			System.out.println(p);
		});
		
	}
	
	
	

}
