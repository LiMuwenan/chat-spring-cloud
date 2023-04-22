package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.service.MsgHandleStrategy;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

public class MsgLeaveStrategy implements MsgHandleStrategy {
    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) throws IOException {
        return null;
    }
}
