package cn.dyaoming.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring.xml")
public class BaseJunit {

	protected static final Logger LOGGER = LogManager.getLogger(BaseJunit.class);



	@Before
	public void before() {
		LOGGER.debug("单元测试运行开始");
	}



	@After
	public void after() {
		LOGGER.debug("单元测试运行结束");
	}
}
