package com.voicecyber.service;

import com.voicecyber.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sean on 2018/7/30
 *
 * @author Sean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplTest {
    @Autowired
    private IUser userService;
    @Test
    public void findUserAll() throws Exception {
        List<User> userAll = userService.findUserAll();
        System.out.println(userAll);
    }

    @Test
    public void findUserById() throws Exception {
    }

    @Test
    public void insertUser() throws Exception {
        User user=new User();
        user.setName("sean1");
        user.setAge(122);
        userService.insertUser(user);
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUserById() throws Exception {
        userService.deleteUserById(2);
    }

}