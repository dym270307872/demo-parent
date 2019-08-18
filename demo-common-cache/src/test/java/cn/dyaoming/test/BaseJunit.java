package cn.dyaoming.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.dyaoming.cache.interfaces.CacheInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring.xml")
public class BaseJunit {
	
	@Autowired
	private CacheInterface cacheDao;
	
	@Test
	public void min() {
		System.out.println("测试类");
		
		System.out.println(JSON.toJSONString(cacheDao.getKeys("cache:systemInfo:*11")));
		
//		System.out.println(JSON.toJSONString(cacheDao.deleteRegexCacheData("cache:systemInfo:system*")));
//		System.out.println(JSON.toJSONString(cacheDao.getKeys("cache:systemInfo:system*")));
		
	}
}
