package com.voicecyber.controller;

import com.voicecyber.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sean on 2018/9/17
 *
 * @author Sean
 */
@RestController
public class KafkaController {
    @Autowired
    private KafkaSender kafkaSender;
    @RequestMapping("send")
    public String send(){
        kafkaSender.sendMsg();
        return "send msg success";
    }
}
