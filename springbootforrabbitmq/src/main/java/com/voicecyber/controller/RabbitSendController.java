package com.voicecyber.controller;

import com.voicecyber.config.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by Sean on 2018/9/7
 *
 * @author Sean
 */
@RestController
public class RabbitSendController {

    @Autowired
    private RabbitSender rabbitSender;
    @RequestMapping("hello")
    public String send(String name){
        String msg= LocalDateTime.now()+name;
        rabbitSender.send(msg);
        return msg;
    }
}
