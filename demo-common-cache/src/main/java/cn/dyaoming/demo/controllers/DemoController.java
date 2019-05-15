package cn.dyaoming.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dyaoming.demo.services.DemoService;


/**
 * <p>演示控制类</p>
 * 
 * @author DYAOMING
 * @since 2019-05-15
 * @version V1.0
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;



	/**
	 * <p>默认缓存演示方法</p>
	 * @param num 随机范围
	 * @return 结果
	 */
	@RequestMapping("default")
	public String defaultmethod(int num) {
		return demoService.defaultService(num);
	}


	/**
	 * <p>公共缓存演示方法</p>
	 * @param num 随机范围
	 * @return 结果
	 */
	@RequestMapping("public")
	public String publicmethod(int num) {
		return demoService.publicService(num);
	}


	/**
	 * <p>用户缓存演示方法</p>
	 * @param num 随机范围
	 * @return 结果
	 */
	@RequestMapping("user")
	public String usermethod(int num) {
		return demoService.userService(num);
	}


	/**
	 * <p>业务缓存演示方法</p>
	 * @param num 随机范围
	 * @return 结果
	 */
	@RequestMapping("business")
	public String businessmethod(int num) {
		return demoService.businessService(num);
	}

}
