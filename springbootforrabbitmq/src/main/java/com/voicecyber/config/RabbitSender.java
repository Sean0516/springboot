package com.voicecyber.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/9/7
 *
 * @author Sean
 */
@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        amqpTemplate.convertAndSend("hello",msg);
    }
}
