package com.voicecyber;

import com.voicecyber.service.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootehcacheApplicationTests {
	@Autowired
	private User user;

	@Test
	public void contextLoads() {
		String sean0516 = user.test("sean0516");
		System.out.println(sean0516);
	}

}
