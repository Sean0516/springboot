package com.voicecyber.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/9/7
 *
 * @author Sean
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitReceiver {
    @RabbitHandler
    public void porcess(Object  hello){
        System.out.println("receiver get "+ hello);
    }
}
