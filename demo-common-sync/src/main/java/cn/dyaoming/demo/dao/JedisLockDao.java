package cn.dyaoming.demo.dao;


import org.springframework.stereotype.Component;

import cn.dyaoming.cache.redistemplate.RedisBaseImp;

@Component("cacheDao")
public class JedisLockDao extends RedisBaseImp {

}
