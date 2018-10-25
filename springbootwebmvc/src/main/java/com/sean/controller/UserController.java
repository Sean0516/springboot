package com.sean.controller;

import com.sean.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Sean on 2018/10/8
 *
 * @author Sean
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "toUser")
    public String toUser(){
        return "user";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@Valid User user , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult);
        }
        System.out.println(user.toString());
        return "add user success";
    }
}
