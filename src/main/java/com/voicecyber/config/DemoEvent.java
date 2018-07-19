package com.voicecyber.config;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Sean on 2018/7/19
 *
 * @author Sean
 */
public class DemoEvent  extends ApplicationEvent{
    private String msg;
    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
