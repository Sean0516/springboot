package com.voicecyber.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/10/24
 *
 * @author Sean
 */
@Component
public class UserEventListener implements ApplicationListener<UserEvent> {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserEventListener.class);
    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        String msg = userEvent.getMsg();
        LOGGER.info("User Event Listener get Msg form UserEvent is "+msg);
    }
}
