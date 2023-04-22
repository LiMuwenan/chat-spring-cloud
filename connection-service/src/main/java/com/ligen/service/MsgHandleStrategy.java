package com.ligen.service;

import com.ligen.entity.ClientComMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

public interface MsgHandleStrategy {

    String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) throws IOException;
}
