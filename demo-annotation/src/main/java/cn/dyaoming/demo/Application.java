package cn.dyaoming.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>启动类</p>
 * 
 * @author DYAOMING
 * @since 2019-04-26
 * @version V1.0
 */
@SpringBootApplication
public class Application {

	/**
	 * <p>主程序入口</p>
	 * @param args 主程序入参
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}
}
