package com.sean;

import com.sean.service.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootconditionApplicationTests {
	@Autowired
	IUser userService;

	@Test
	public void contextLoads() {
		userService.getName();
	}
}
