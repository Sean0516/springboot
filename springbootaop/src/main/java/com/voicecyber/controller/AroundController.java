package com.voicecyber.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
@RestController
public class AroundController {
    @RequestMapping("around")
    public String around(String name){
        return "this is around advice test name: " +name;
    }
}
