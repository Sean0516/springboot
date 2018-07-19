package com.voicecyber.config;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/7/19
 *
 * @author Sean
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg=demoEvent.getMsg();
        System.out.println("DemoListener 接收到：demoEvent 的信息"+ msg);
    }
}
