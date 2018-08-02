package com.sean.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Sean on 2018/8/1
 *
 * @author Sean
 */
@Component
public class ApplicationConfig implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextClosedEvent){
            System.out.println(event.getClass().getSimpleName()+"关闭事件已发生222！");
        }else if(event instanceof ContextRefreshedEvent){
            System.out.println(event.getClass().getSimpleName()+" 刷新事件已发生22！");
        }else if(event instanceof ContextStartedEvent){
            System.out.println(event.getClass().getSimpleName()+" 开始事件已发生22！");
        }else if(event instanceof ContextStoppedEvent){
            System.out.println(event.getClass().getSimpleName()+" 停止事件已发生22！");
        }else{
            System.out.println("有其它事件发生22:"+event.getClass().getName());
        }

    }
}
