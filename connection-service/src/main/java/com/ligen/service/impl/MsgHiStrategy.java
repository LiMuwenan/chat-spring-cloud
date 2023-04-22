package com.ligen.service.impl;

import com.ligen.constant.MsgConstants;
import com.ligen.entity.ClientComMessage;
import com.ligen.entity.message.client.MsgClientHi;
import com.ligen.service.MsgHandleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

public class MsgHiStrategy implements MsgHandleStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgHiStrategy.class);

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) throws IOException {
        MsgClientHi hi = clientComMessage.getHi();
        if (!MsgConstants.MSG_VERSION.equals(hi.getVer())) {
            LOGGER.error("连接使用的消息版本号不兼容");
            throw new IllegalArgumentException("连接使用的消息版本号不兼容");
        }

        return "hi";
    }
}
