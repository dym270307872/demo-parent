package cn.dyaoming.demo.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.dyaoming.cache.redistemplate.AbstractRedisBaseImp;

@Component("cacheDao")
@Scope("prototype")
public class JedisLockDao extends AbstractRedisBaseImp {

}
