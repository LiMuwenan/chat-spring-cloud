package com.ligen.controller;

import com.ligen.handler.WebSocketMessageHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class SessionController {

    @Resource
    private WebSocketMessageHandler handler;

    @RequestMapping(method = RequestMethod.POST, path = "/session/get/{sessionId}")
    public String session(@PathVariable String sessionId) {
        WebSocketSession session = handler.getSession(sessionId);

        try {
            session.sendMessage(new TextMessage("获取成功"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "获得连接";
    }
}
