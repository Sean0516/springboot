package com.voicecyber;

import com.voicecyber.mapper.UserMapper;
import com.voicecyber.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpingbootmybatisApplicationTests {
	@Resource
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		User user=new User();
		user.setName("sea22n");
		user.setAge(12);
		userMapper.insertSelective(user);
	}

}
