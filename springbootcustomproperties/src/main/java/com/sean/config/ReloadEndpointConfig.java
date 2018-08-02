package com.sean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sean on 2018/8/1
 *
 * @author Sean
 */
@Configuration
public class ReloadEndpointConfig {
    @Bean
    public ReloadEndpoint reloadEndpoint(){
        return new ReloadEndpoint();
    }
}
