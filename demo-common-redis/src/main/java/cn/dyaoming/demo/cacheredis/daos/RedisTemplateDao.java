package cn.dyaoming.demo.cacheredis.daos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.dyaoming.cache.interfaces.CacheInterface;
import cn.dyaoming.cache.redistemplate.AbstractRedisRegexImp;

//@Component("cacheDao")
@Scope("prototype")
public class RedisTemplateDao extends AbstractRedisRegexImp implements CacheInterface {
    
}
