package com.ligen.config;

import com.ligen.handler.WebSocketMessageHandler;
import com.ligen.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    private WebSocketInterceptor webSocketInterceptor;

    /**
     * 注册websocket连接路径，配置拦截器
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // websocket连接路径 ws://localhost:8101/message
        registry.addHandler(msgHandler(), "/message")
                .addInterceptors(webSocketInterceptor);
    }

    /**
     * 返回一个WebSocketHandler，包含了主要的websocket连接后接收发送消息等逻辑
     * @return
     */
    @Bean
    public WebSocketHandler msgHandler() {
        return new WebSocketMessageHandler();
    }

}
