package cn.dyaoming.demo.cacheredis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisList {

	@Autowired
	private JedisPool jedisPool;
	
	
	public void testListSort() {
		Jedis jedis = jedisPool.getResource();
		
		String cacheKey = "";
		List<String> list = new ArrayList<>();
		
//		jedis.rpush(key, strings)
		
//      jedis.rpush(cacheKey, list);
//      jedis.sort(key);
		
	}
}
