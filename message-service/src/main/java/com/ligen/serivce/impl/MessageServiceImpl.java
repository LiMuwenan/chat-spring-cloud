package com.ligen.serivce.impl;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.Message;
import com.ligen.mapper.MessageMapper;
import com.ligen.serivce.MessageService;
import com.ligen.util.RedisKeyUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public int createNewMessage(long topic, long fromUser, String content, String head, int seqId) {

        Integer maxSeqId = (Integer) redisTemplate.opsForValue().get(RedisKeyUtil.msgSeqKey(topic));
        if (maxSeqId == null) {
            maxSeqId = 0;
        }
        if (seqId <= maxSeqId) {
            return 0;
        }
        maxSeqId++;
        redisTemplate.opsForValue().set(RedisKeyUtil.msgSeqKey(topic), maxSeqId);
        Message message = new Message();
        message.setUpdateDat(new Timestamp(System.currentTimeMillis()));
        message.setHead(head);
        HashMap<String ,String> contentMap = new HashMap<>();
        contentMap.put("content", content);
        message.setContent(JSONObject.toJSONString(contentMap));
        message.setSeqId(maxSeqId);
        message.setFrom(fromUser);
        message.setTopic(topic);

        return messageMapper.insertMessage(message);
    }
}
