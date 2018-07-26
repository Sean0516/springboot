package com.voicecyber.config;

import com.voicecyber.handler.TestWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Sean on 2018/7/26
 *
 * @author Sean
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
//        设置url  和handler
        webSocketHandlerRegistry.addHandler(testWebSocketHandler(), "/test1").setAllowedOrigins("*");
    }

    /**
     * 注入自定义的handler
     * @return
     */
    @Bean
    public TestWebSocketHandler testWebSocketHandler() {
        return new TestWebSocketHandler();
    }
}
