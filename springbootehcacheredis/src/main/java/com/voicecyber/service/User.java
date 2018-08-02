package com.voicecyber.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@Service
public class User {
    @Cacheable(key = "#key")
    public String test(String key) {
        System.out.println("进入获取数据");
        String str = "key" + key + "hello";
        System.out.println("获取数据结束");
        return str;
    }

}
