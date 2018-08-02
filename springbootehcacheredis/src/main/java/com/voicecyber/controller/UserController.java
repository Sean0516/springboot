package com.voicecyber.controller;

import com.voicecyber.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@RestController
public class UserController {
    @Autowired
    private User user;
    @RequestMapping(value = "user")
    public String user(String key){
       return user.test(key);
    }
}
