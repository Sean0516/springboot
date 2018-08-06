package com.voicecyber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by Sean on 2018/8/6
 * 跨域支持
 * @author Sean
 */
@Configuration
public class CorsConfig {
    public CorsConfiguration corsConfiguration(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        //1 设置访问源地址
        corsConfiguration.addAllowedOrigin("*");
        //  设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");
        //  设置访问源请求头
        corsConfiguration.addAllowedHeader("*");
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        //对接口配置跨域设置
        source.registerCorsConfiguration("/**",corsConfiguration());
        return new CorsFilter(source);
    }
}
