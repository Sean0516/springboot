package com.voicecyber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/7/19
 *
 * @author Sean
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;
    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}
