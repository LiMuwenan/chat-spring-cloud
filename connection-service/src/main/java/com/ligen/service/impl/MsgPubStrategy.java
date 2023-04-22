package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.service.MsgHandleStrategy;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;

public class MsgPubStrategy implements MsgHandleStrategy {

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) {
        return null;
    }
}
