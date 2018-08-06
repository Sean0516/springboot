package com.voicecyber;

import com.voicecyber.service.UserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootsecurityApplicationTests {
	@Autowired
	UserImpl user;
	@Test
	public void contextLoads() {
		user.test("444ssss");
	}

}
