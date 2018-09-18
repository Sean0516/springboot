package com.voicecyber.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/9/17
 *
 * @author Sean
 */
@Component
public class KafkaMsgConsumer {
    private static Logger logger= LoggerFactory.getLogger(KafkaMsgConsumer.class);
    @KafkaListener(topics = {"test-topic"})
    public void consumer(String message){
        logger.info("get test topic message from sender : {}",message);
    }
}
