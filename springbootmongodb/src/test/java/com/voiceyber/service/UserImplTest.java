package com.voiceyber.service;

import com.voiceyber.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplTest {
    @Autowired
    private IUser userService;

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userService.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void getUserByName() throws Exception {
        User sean = userService.getUserByName("sean");
        System.out.println(sean.toString());
    }

    @Test
    public void insert() throws Exception {
        User user=new User("sean",22);
        userService.insert(user);
    }

    @Test
    public void update() throws Exception {
        User user=new User("master",22);
        user.setId("5b5fc230db3137287886d41e");
        userService.update(user);
    }

    @Test
    public void removeByName() throws Exception {
        userService.removeByName("sean");
    }

}