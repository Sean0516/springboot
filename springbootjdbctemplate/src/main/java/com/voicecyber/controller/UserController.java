package com.voicecyber.controller;

import com.voicecyber.model.User;
import com.voicecyber.service.user.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private IUser userService;

    @RequestMapping("getUserList")
    public List<User> userList(){
        List<User> userList = userService.findUserAll();
        return userList;
    }
    @RequestMapping("getUser")
    public User getUser(int id){
        User user = userService.findUserById(id);
        return user;
    }
    @RequestMapping("add")
    public String add(){
        userService.insertUser(new User(null,"hello",12,"男"));
        return "add user";
    }
    @RequestMapping("edit")
    public String edit(Integer id){
        userService.updateUser(new User(id,"test",123,"女"));
        return "edit user";
    }
    @RequestMapping("delete")
    public String delete(int id){
        userService.deleteUserById(id);
        return "delete user "+id;
    }
}
