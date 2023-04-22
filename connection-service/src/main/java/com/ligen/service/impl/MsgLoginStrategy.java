package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.entity.message.client.MsgClientLogin;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.client.AuthServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.util.Map;

public class MsgLoginStrategy implements MsgHandleStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgLoginStrategy.class);

    private AuthServiceClient authClient;

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) {
        MsgClientLogin login = clientComMessage.getLogin();
        // 登录
        long uid = authClient.receiveLogin(login.toString(), clientComMessage.getSession().getId(), "127.0.0.1");

        // 登录成功将连接信息加入池子
        if (uid != 0) {
            sessionPool.put(String.valueOf(uid), clientComMessage.getSession());
        }
        LOGGER.info(String.valueOf(uid));
        return "login";
    }
}
