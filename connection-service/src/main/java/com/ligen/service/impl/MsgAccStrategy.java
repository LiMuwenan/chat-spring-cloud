package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.entity.message.client.MsgClientAcc;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.client.AuthServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Service("AccStrategy")
public class MsgAccStrategy implements MsgHandleStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgAccStrategy.class);

    @Resource
    private AuthServiceClient authClient;

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) throws IOException {
        MsgClientAcc acc = clientComMessage.getAcc();
        LOGGER.info(acc.toString());

        // 注册
        String receive = authClient.receiveAcc(acc.toString());
        LOGGER.info("connection-service:" + receive);
        // 注册成功由前端再自动提交登录请求

        return "acc";
    }
}
