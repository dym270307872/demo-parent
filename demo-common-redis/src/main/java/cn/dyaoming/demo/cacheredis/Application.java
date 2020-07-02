package cn.dyaoming.demo.cacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author dyaoming
 */
@Configuration
@SpringBootApplication
//@EnableRedisRepositories
//@EnableCaching
@ComponentScan(basePackages = "cn.dyaoming")
public class Application {

    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
      }
}
