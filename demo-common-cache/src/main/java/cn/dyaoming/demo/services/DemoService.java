package cn.dyaoming.demo.services;


import java.util.Random;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 演示业务层
 * </p>
 * 
 * @author DYAOMING
 * @since 2019-05-15
 * @version V1.0
 */
@Service
public class DemoService {

	/**
	 * <p>
	 * 默认缓存业务层
	 * </p>
	 * 
	 * @param num 随机范围
	 * @return 返还值
	 */
	@Cacheable("default")
	public String defaultService(int num) {
		return "默认缓存方法返回随机值:" + new Random().nextInt(num);
	}



	/**
	 * <p>
	 * 公共缓存业务层
	 * </p>
	 * 
	 * @param num 随机范围
	 * @return 返还值
	 */
	@Cacheable("publicInfo")
	public String publicService(int num) {
		return "公共缓存方法返回随机值:" + new Random().nextInt(num);
	}



	/**
	 * <p>
	 * 用户缓存业务层
	 * </p>
	 * 
	 * @param num 随机范围
	 * @return 返还值
	 */
	@Cacheable("userInfo")
	public String userService(int num) {
		return "用户缓存方法返回随机值:" + new Random().nextInt(num);
	}



	/**
	 * <p>
	 * 业务缓存业务层
	 * </p>
	 * 
	 * @param num 随机范围
	 * @return 返还值
	 */
	@Cacheable("businessInfo")
	public String businessService(int num) {
		return "业务缓存方法返回随机值:" + new Random().nextInt(num);
	}



	/**
	 * <p>
	 * 业务缓存业务层
	 * </p>
	 * 
	 * @param num 随机范围
	 * @return 返还值
	 */
	@CacheEvict(value = "businessInfo", key = "'*['+#num+']'")
	public void chear(int num) {

	}

}
