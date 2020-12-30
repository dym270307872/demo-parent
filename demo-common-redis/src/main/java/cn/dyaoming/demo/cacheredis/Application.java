package cn.dyaoming.demo.cacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import cn.dyaoming.cache.annotation.EnableCommonCache;

/**
 * 
 * @author dyaoming
 */
@Configuration
@EnableCommonCache
@SpringBootApplication
//@ComponentScan("cn.dyaoming.demo")
//@ComponentScans({@ComponentScan("cn.dyaoming.utils"),@ComponentScan("cn.dyaoming.demo")})
public class Application {

    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
      }
}
