package cn.dyaoming.demo.cacheredis.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations= {"classpath:application-cache.xml"})
public class CacheConfig {

    
    
}
