package com.sean.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
    public String sayHello() {
        if (1 == 1) {
            throw new RuntimeException("server error");
        }
        return "hello sean";
    }

    @RequestMapping("test/{name}")
    public String test(@PathVariable(value = "name") String name) {
        return "hello " + name;
    }

}
