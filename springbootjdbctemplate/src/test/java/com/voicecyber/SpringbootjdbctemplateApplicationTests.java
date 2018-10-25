package com.voicecyber;

import com.voicecyber.model.User;
import com.voicecyber.service.user.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootjdbctemplateApplicationTests {
	@Autowired
	IUser userService;
	@Test
	public void contextLoads() {
		User userPrepStatementById = userService.findUserPrepStatementById(2);
		System.out.println(userPrepStatementById);
	}

}
