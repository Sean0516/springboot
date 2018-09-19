package com.voicecyber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
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

    @MessageMapping("/test")
    public String userInfo() {
        System.out.println("sss");
        return "test11112";
    }
    @MessageMapping("/user")
    public String userName(){
        return "hello sean";
    }


//    @Scheduled(initialDelay=1000 ,fixedDelay = 1000*10)
//    public void subscribeTest() {
//        System.out.println("发送消息给客户端");
//        messagingTemplate.convertAndSend("/topic/subscribeTest", LocalDateTime.now().toString());
//    }

}
