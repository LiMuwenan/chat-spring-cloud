package com.ligen.handler;

import com.alibaba.fastjson.JSONObject;
import com.ligen.constant.MsgConstants;
import com.ligen.entity.message.ClientComMessage;
import com.ligen.entity.message.client.MsgClientAcc;
import com.ligen.entity.message.client.MsgClientHi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class WebSocketMessageHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketMessageHandler.class);

    // 保存正常连接
    private static final Map<String, WebSocketSession> sessionPool = new HashMap<>();

    //
    @Resource
    private RestTemplate template;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("WebSocket连接建立：sessionId={}", session.getId());
        sessionPool.put(session.getId(), session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        LOGGER.info("收到WebSocket消息：sessionId={}, message={}", session.getId(), message.getPayload());
        String string = message.getPayload().toString(); // 消息字符串

        // 反序列化消息包
        ClientComMessage clientComMessage = JSONObject.parseObject(string, ClientComMessage.class);
        clientComMessage.setSession(session);
        clientComMessage.setTimestamp(LocalDateTime.now());
        // {Hi}
        if (clientComMessage.getHi() != null) {
            clientComMessage.setInit(true); // 初始化连接
            handleHi(clientComMessage);
        }
        // {Acc}
        if (clientComMessage.getAcc() != null) {
            handleAcc(clientComMessage);
        }
        // {Login}
        if (clientComMessage.getLogin() != null) {
            handleLogin(clientComMessage);
        }
        // {Sub}
        if (clientComMessage.getSub() != null) {
            handleSub(clientComMessage);
        }
        // {Leave}
        if (clientComMessage.getLeave() != null) {
            handleLeave(clientComMessage);
        }
        // {Pub}
        if (clientComMessage.getPub() != null) {
            handlePub(clientComMessage);
        }
        // {Get}
        if (clientComMessage.getGet() != null) {
            handleGet(clientComMessage);
        }
        // {Set}
        if (clientComMessage.getSet() != null) {
            handleSet(clientComMessage);
        }
        // {Del}
        if (clientComMessage.getDel() != null) {
            handleDel(clientComMessage);
        }
        // {Note}
        if (clientComMessage.getNote() != null) {
            handleNote(clientComMessage);
        }

        LOGGER.info(clientComMessage.toString());



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
        sessionPool.remove(session.getId(), session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public WebSocketSession getSession(String sessionId) {
        return sessionPool.get(sessionId);
    }

    // 处理{hi}的消息
    private void handleHi(ClientComMessage clientComMessage) {
        MsgClientHi hi = clientComMessage.getHi();
        if (!MsgConstants.MSG_VERSION.equals(hi.getVer())) {
            LOGGER.error("连接使用的消息版本号不兼容");
            throw new IllegalArgumentException("连接使用的消息版本号不兼容");
        }

    }

    // 处理{acc}的消息
    private void handleAcc(ClientComMessage clientComMessage) {
        MsgClientAcc acc = clientComMessage.getAcc();
        // auth
        // http://localhost:8001/register/token
        // http://localhost:8001/register/basic
        // http://localhost:8001/register/reset
        ResponseEntity<String> stringResponseEntity = template.postForEntity("http://localhost:8001/" + acc.getScheme(), null, String.class);
        String body = stringResponseEntity.getBody();
        LOGGER.info(body);

    }

    // 处理{login}的消息
    private void handleLogin(ClientComMessage clientComMessage) {

    }

    // 处理{sub}的消息
    private void handleSub(ClientComMessage clientComMessage) {

    }

    // 处理{leave}的消息
    private void handleLeave(ClientComMessage clientComMessage) {

    }

    // 处理{pub}的消息
    private void handlePub(ClientComMessage clientComMessage) {

    }

    // 处理{get}的消息
    private void handleGet(ClientComMessage clientComMessage) {

    }

    // 处理{set}的消息
    private void handleSet(ClientComMessage clientComMessage) {

    }

    // 处理{del}的消息
    private void handleDel(ClientComMessage clientComMessage) {

    }

    // 处理{note}的消息
    private void handleNote(ClientComMessage clientComMessage) {

    }

}