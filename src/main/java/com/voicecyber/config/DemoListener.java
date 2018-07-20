package com.voicecyber.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sean on 2018/7/19
 *
 * @author Sean
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Value("${book.name}")
    private String name;
    @Value("classpath:test.txt")
    private Resource resourceFile;
    @Value("https://www.baidu.com/")
    private Resource httpResource;
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String string="";
        String http="";
        try {
            string = FileCopyUtils.copyToString(new InputStreamReader(resourceFile.getInputStream()));
            http=FileCopyUtils.copyToString(new InputStreamReader(httpResource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg=demoEvent.getMsg();
        System.out.println("DemoListener 接收到：demoEvent 的信息"+ msg+"name: " +name +"file "+string +"http: "+http);
    }
}
