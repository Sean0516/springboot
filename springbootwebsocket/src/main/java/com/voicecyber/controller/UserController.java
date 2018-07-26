package com.voicecyber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Sean on 2018/7/26
 *
 * @author Sean
 */
@Controller
public class UserController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @RequestMapping("user")
    public String user() {
        return "ws";
    }

    @MessageMapping("test")
    @SendTo("/topic/userInfo")
    public String userInfo() {
        System.out.println("sss");
        return "test11112";
    }

    @Scheduled(fixedRate = 1000*2)
    @SendTo("/topic/subscribeTest")
    public void subscribeTest() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", LocalDateTime.now().toString());
    }

}
