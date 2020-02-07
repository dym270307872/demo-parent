package cn.dyaoming.demo.dao;


import java.io.UnsupportedEncodingException;
import java.util.*;

import cn.dyaoming.cache.interfaces.CacheInterface;
import cn.dyaoming.errors.AppDaoException;
import cn.dyaoming.utils.AesUtil;
import cn.dyaoming.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.util.StringUtils;


/**
 * <p>
 * 使用redis的实现类
 * </p>
 * 
 * @author DYAOMING
 * @since 2019-05-15
 * @version V1.0
 */
public class RedisTemplateImp extends RedisRegexImp implements CacheInterface {

	@Autowired
	private RedisTemplate		redisTemplate;



	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}



	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


}
