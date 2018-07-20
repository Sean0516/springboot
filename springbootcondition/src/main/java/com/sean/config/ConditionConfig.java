package com.sean.config;

import com.sean.service.IUser;
import com.sean.service.LinuxUserImpl;
import com.sean.service.WindowsUserImol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public IUser windowsUser(){
        return new WindowsUserImol();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public IUser linuxUser(){
        return new LinuxUserImpl();
    }
}
