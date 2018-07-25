package com.sean.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/7/23
 *
 * @author Sean
 */
@RestController
@RequestMapping(value = "demo")
public class TestController {
    @RequestMapping(value = "test")
    public String test(@ModelAttribute("msg") String msg) {
        return "this is test and  global msg  " + msg;
    }

    @RequestMapping(value = "error")
    public String error() {
        if (1 == 1) {
            throw new RuntimeException("this is error test");
        }
        return "this is error";
    }
}
