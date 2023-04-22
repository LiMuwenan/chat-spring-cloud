package com.ligen.service.impl;

import com.ligen.entity.ClientComMessage;
import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.client.SearchServiceClient;
import com.ligen.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

public class MsgGetStrategy  implements MsgHandleStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgGetStrategy.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private SearchServiceClient searchClient;

    @Override
    public String msgHandle(ClientComMessage clientComMessage, Map<String, WebSocketSession> sessionPool) throws IOException {
        WebSocketSession session = clientComMessage.getSession();
        Boolean hasKey = redisTemplate.hasKey(RedisKeyUtil.onlineKey(Long.parseLong(clientComMessage.getAsUser())));
        if (!hasKey) {
            session.close();
        }
        String s = searchClient.receiveGet(clientComMessage.getGet().toString());
        LOGGER.info(s);

        return "get";
    }
}
