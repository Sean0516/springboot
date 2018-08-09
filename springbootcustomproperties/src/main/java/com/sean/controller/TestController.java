package com.sean.controller;

import com.sean.SpringbootcustompropertiesApplication;
import com.sean.config.ApplicationConfig;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;


/**
 * Created by Sean on 2018/8/1
 *
 * @author Sean
 */
@RestController
public class TestController {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${sean.name}")
    private String name;
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("test")
    public String test() {
        return url + name;
    }
    @RequestMapping("deleteBean")
    public void restart() {
        DefaultListableBeanFactory defaultListableBeanFactory= (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        defaultListableBeanFactory.removeBeanDefinition("properties");
    }
    @RequestMapping("addBean")
    public void addBean(){
        DefaultListableBeanFactory defaultListableBeanFactory= (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(PropertySourcesPlaceholderConfigurer.class);
        defaultListableBeanFactory.registerBeanDefinition("properties",beanDefinitionBuilder.getBeanDefinition());
    }
    @RequestMapping("editBean")
    public void editBean(){

    }

}
