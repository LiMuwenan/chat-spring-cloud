package com.ligen.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;


public class WebSocketMessageHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketMessageHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("WebSocket连接建立：sessionId={}", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("收到WebSocket消息：sessionId={}, message={}", session.getId(), message.getPayload());
        String string = message.getPayload().toString(); // 消息字符串
        // 反序列化消息包

        // 验证版本xxxx

        // 统一处理


        // 返回消息

        session.sendMessage(new TextMessage("返回消息"));
    }

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info("收到WebSocket消息：sessionId={}, message={}", session.getId(), message.getPayload());
        session.sendMessage(new TextMessage("Hello, " + message.getPayload() + "!"));
    }

    public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        // 处理二进制消息
    }

    public void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        // 处理心跳消息
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        LOGGER.error("WebSocket传输错误：sessionId={}, error={}", session.getId(), exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("WebSocket连接关闭：sessionId={}, status={}", session.getId(), status);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}