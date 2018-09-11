package com.voicecyber.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
@RestController
public class AdviceController {
    @RequestMapping("test")
    public String test(String name){
        return "hello" +name;
    }
}
