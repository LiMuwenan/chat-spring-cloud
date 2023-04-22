package com.ligen.handler;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.ClientComMessage;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.util.CommonConstant;
import com.ligen.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class WebSocketMessageHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketMessageHandler.class);

    // 保存正常连接
    private static final Map<String, WebSocketSession> sessionPool = new HashMap<>(); // key:uid

    @Resource
    private HashMap<String, MsgHandleStrategy> msgStrategy;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("WebSocket连接建立：sessionId={}", session.getId());
        redisTemplate.opsForValue().set(RedisKeyUtil.aliveKey(session.getId()), session.getRemoteAddress().toString(),
                CommonConstant.EXPIRED_TIME, TimeUnit.SECONDS);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("收到WebSocket消息：sessionId={}, message={}", session.getId(), message.getPayload());
        redisTemplate.opsForValue().set(RedisKeyUtil.aliveKey(session.getId()), session.getRemoteAddress().toString(),
                CommonConstant.EXPIRED_TIME, TimeUnit.SECONDS);
        String string = message.getPayload().toString(); // 消息字符串

        // 反序列化消息包
        ClientComMessage clientComMessage = JSONObject.parseObject(string, ClientComMessage.class);
        clientComMessage.setSession(session);
        clientComMessage.setTimestamp(LocalDateTime.now());

        String responseMsg = msgStrategy.get(clientComMessage.getType()).msgHandle(clientComMessage, sessionPool);

        LOGGER.info(clientComMessage.toString());
        // 验证版本xxxx

        // 统一处理


        // 返回消息

        session.sendMessage(new TextMessage(responseMsg));
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
        redisTemplate.delete(RedisKeyUtil.aliveKey(session.getId()));

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public WebSocketSession getSession(String uid) {
        return sessionPool.get(uid);
    }

}