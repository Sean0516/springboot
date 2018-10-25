package com.voicecyber.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Sean on 2018/10/24
 *
 * @author Sean
 */
public class UserEvent extends ApplicationEvent {
    private String msg;
    public UserEvent(Object source ,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
