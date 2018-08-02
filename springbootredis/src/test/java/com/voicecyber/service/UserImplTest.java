package com.voicecyber.service;

import com.voicecyber.model.User;
import com.voicecyber.service.user.IUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserImplTest {
    @Autowired
    IUser userService;
    @Test
    public void add() throws Exception {
        User user =new User();
        user.setName("sean");
        user.setAge(22);
        userService.add("sean0516",user);
    }

    @Test
    public void add1() throws Exception {
        User user =new User();
        user.setName("sean");
        user.setAge(22);
        User user1=new User();
        user1.setName("master");
        user1.setAge(23);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userService.add("addBatch",userList);
    }

    @Test
    public void getUserList() throws Exception {
        List<User> addBatch = userService.getUserList("addBatch");
        System.out.println(addBatch.size());
    }

    @Test
    public void getUser() throws Exception {
        User sean0516 = userService.getUser("sean0516");
        System.out.println(sean0516.toString());
    }

    @Test
    public void delete() throws Exception {
        userService.delete("sean0516");
    }

}