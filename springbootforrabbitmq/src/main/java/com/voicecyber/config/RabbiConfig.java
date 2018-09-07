package com.voicecyber.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sean on 2018/9/7
 *
 * @author Sean
 */
@Configuration
public class RabbiConfig {
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
