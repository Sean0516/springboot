package com.voicecyber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sean on 2018/7/26
 *
 * @author Sean
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
