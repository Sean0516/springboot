package com.sean;

import com.sean.config.UserPropertiesConfig;
import com.sean.config.YmlFileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcustompropertiesApplicationTests {
	private final static Logger LOGGER= LoggerFactory.getLogger(SpringbootcustompropertiesApplicationTests.class);
	@Autowired
	private UserPropertiesConfig userPropertiesConfig;
	@Autowired
	private YmlFileConfig  ymlFileConfig;

	@Test
	public void contextLoads() {
		LOGGER.error(userPropertiesConfig.getName());
		LOGGER.info(userPropertiesConfig.getPassword());
	}
	@Test
	public void test(){
	}

}
