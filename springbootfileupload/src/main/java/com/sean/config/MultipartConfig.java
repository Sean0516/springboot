package com.sean.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;

/**
 * Created by Sean on 2018/7/23
 *
 * @author Sean
 */
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory=new MultipartConfigFactory();
        //设置文件上传大小
        factory.setMaxFileSize("256KB");
        //设置总上传文件总大小
        factory.setMaxRequestSize("512KB");
        //设置文件上传路径
        factory.setLocation("D:/temp/");

        return factory.createMultipartConfig();
    }
}
