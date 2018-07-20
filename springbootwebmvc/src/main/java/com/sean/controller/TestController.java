package com.sean.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@RestController
@RequestMapping(value = "test1")
public class TestController {
    @RequestMapping(value = "hello")
    public String sayHello(){
        return "hello sean";
    }
}
