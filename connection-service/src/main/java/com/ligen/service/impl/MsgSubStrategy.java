package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.entity.message.client.MsgClientSub;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.client.TopicServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.util.Map;

@Service("SubStrategy")
public class MsgSubStrategy  implements MsgHandleStrategy {

    @Resource
    private TopicServiceClient topicClient;

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) {
        MsgClientSub sub = clientComMessage.getSub();
        if (clientComMessage.getRcptTo() != null ) {
            topicClient.subNewTopic(Long.parseLong(clientComMessage.getAsUser()), Long.parseLong(clientComMessage.getRcptTo()), "1");
        } else {
            topicClient.subNewTopic(Long.parseLong(clientComMessage.getAsUser()), 0, "1");
        }
        return "创建";
    }
}
