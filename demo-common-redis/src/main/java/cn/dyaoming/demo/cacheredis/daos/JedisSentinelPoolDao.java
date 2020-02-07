package cn.dyaoming.demo.cacheredis.daos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.dyaoming.cache.interfaces.CacheInterface;
import cn.dyaoming.cache.jedissentinel.RedisRegexImp;


@Component("cacheDao")
@Scope("prototype")
public class JedisSentinelPoolDao extends RedisRegexImp implements CacheInterface{

}
