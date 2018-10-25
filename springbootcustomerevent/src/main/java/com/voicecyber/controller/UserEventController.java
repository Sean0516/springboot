package com.voicecyber.controller;

import com.voicecyber.event.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/10/24
 *
 * @author Sean
 */
@RestController
public class UserEventController {
    @Autowired
    private UserEventPublisher userEventPublisher;
    @RequestMapping("publish")
    public String publish(){
        userEventPublisher.publish("hello user");
        return "publish event";
    }
}
