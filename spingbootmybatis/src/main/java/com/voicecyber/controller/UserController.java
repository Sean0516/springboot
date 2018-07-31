package com.voicecyber.controller;

import com.voicecyber.model.User;
import com.voicecyber.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sean on 2018/7/30
 *
 * @author Sean
 */
@RestController
public class UserController {
    @Autowired
    IUser userService;
    @RequestMapping("getAllUser")
    public List<User> getAllUser(){
        List<User> userAll = userService.findUserAll();
        return userAll;
    }
    @RequestMapping(value = "getUser")
    public User getUser(int id){
       return userService.findUserById(id);
    }
    @RequestMapping(value = "insertUser")
    public void insertUser(){
        User user=new User();
        user.setName("tes12t");
        user.setAge(222);
        user.setId(5);
        userService.updateUser(user);
    }
}
