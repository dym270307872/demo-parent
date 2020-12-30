package cn.dyaoming.demo.cacheredis.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import cn.dyaoming.cache.DefaultCacheConfig;


//@Configuration
@Import(value=DefaultCacheConfig.class)
//@ComponentScan("cn.dyaoming.utils")
//@ImportResource(locations= {"classpath:application-cache.xml"})
public class CacheConfig{

    
    
}
