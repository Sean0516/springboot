package com.voicecyber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
@RestController
public class AdviceController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test")
    public String test(String name) {
        if ("sean".equals(name)) {
            throw new RuntimeException("test error");
        }
        return "hello" + name;
    }

    @RequestMapping(value = "name")
    public String name(int age, String... name) {
        for (String s : name) {
            System.out.println(s);
        }
        return "getName" + age;
    }

    @RequestMapping(value = "restTest")
    public ResponseEntity restTest() {
//        ResponseEntity<String> responseEntity  = restTemplate.getForEntity("http://localhost:8080/name?name={name}", String.class,"name,test,master" );
        Map map = new HashMap(2);
        map.put("name", "name,test,master");
        map.put("age", 22);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/name?name={name}&age={age}", HttpMethod.GET, null, String.class, map);
        return responseEntity;

    }
}
