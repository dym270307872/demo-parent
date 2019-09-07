package cn.dyaoming.test;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dyaoming.cache.interfaces.CacheBaseInterface;
import cn.dyaoming.cache.interfaces.CacheBatchInterface;
import cn.dyaoming.cache.interfaces.CacheInterface;


public class BatchDemo extends BaseJunit {

	@Autowired
	private CacheBatchInterface cacheBatchDao;



	@Test
	public void demo1() {

		// 从左边插入一个数组
		// String[] books = new String[] { "java编程思想", "springboot从入门到精通" };
		// cacheBatchDao.setList("product:list", books);
		// cacheBatchDao.setList("product:list", "iphone xs max");

		List<String> resultList1 = cacheBatchDao.getList("product:list");
		System.out.println(resultList1);
		String[] books2 = new String[] { "java编程思想1", "springboot从入门到精通2", "java编程思想3",
				"springboot从入门到精通4" };
		cacheBatchDao.setList("product:list", books2);
		List<String> resultList2 = cacheBatchDao.getList("product:list");
		System.out.println(resultList2);
	}
	
	
	

}
