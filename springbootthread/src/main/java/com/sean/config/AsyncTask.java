package com.sean.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@Service
public class AsyncTask {
    @Async
    public void sayHello(String name){
        System.out.println(Thread.currentThread().getName()+"___"+name);
    }
    @Async
    public void getName(String name){
        System.out.println(Thread.currentThread().getName()+"___"+name);
    }
}
