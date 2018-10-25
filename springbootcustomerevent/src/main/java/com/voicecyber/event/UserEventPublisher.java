package com.voicecyber.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/10/24
 *
 * @author Sean
 */
@Component
public class UserEventPublisher {
    @Autowired
    private ApplicationContext applicationContext;
    public void publish(String msg){
        applicationContext.publishEvent(new UserEvent(this,msg));
    }

}
