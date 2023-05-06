package com.ligen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.ClientComMessage;
import com.ligen.entity.message.client.MsgClientPub;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.client.MessageServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.util.Map;

@Service("PubStrategy")
public class MsgPubStrategy implements MsgHandleStrategy {

    @Resource
    private MessageServiceClient messageClient;

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) {
        MsgClientPub pub = clientComMessage.getPub();

        return messageClient.receivePub(pub.getTopic(),
                Long.parseLong(clientComMessage.getAsUser()),
                pub.getContent(),
                JSONObject.toJSONString(pub.getHead()),
                Integer.parseInt(pub.getId()));
    }
}
