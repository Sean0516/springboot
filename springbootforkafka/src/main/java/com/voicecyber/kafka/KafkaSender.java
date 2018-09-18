package com.voicecyber.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Sean on 2018/9/17
 *
 * @author Sean
 */
@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMsg(){
        kafkaTemplate.send("test-topic","hello world "+ LocalDateTime.now());
    }
}
