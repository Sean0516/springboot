package com.sean.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@RestController
@RequestMapping(value = "test2")
public class Test1Controller {
    @RequestMapping("user")
    public String getName(){
        return "I am Sean";
    }
}
