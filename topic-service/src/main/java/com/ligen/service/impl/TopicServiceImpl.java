package com.ligen.service.impl;

import com.ligen.entity.Subscriptions;
import com.ligen.entity.Topic;
import com.ligen.entity.message.client.MsgClientSub;
import com.ligen.mapper.SubMapper;
import com.ligen.mapper.TopicMapper;
import com.ligen.service.TopicService;
import com.ligen.util.TopicConstant;
import com.ligen.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class TopicServiceImpl implements TopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private SubMapper subMapper;

    @Override
    public Topic searchTopic(String opts, int type) {
        Topic topic = topicMapper.selectTopic(opts, type);
        LOGGER.info(topic.toString());
        return topic;
    }

    // 1.新建p2p topic
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public String subNewP2PTopic(long userFrom, long userTo) {

        Topic newTopic = new Topic();
        newTopic.setCreateDat(new Timestamp(System.currentTimeMillis()));
        newTopic.setUpdateDat(newTopic.getCreateDat());
        newTopic.setState(TopicConstant.TOPIC_STATE_OK);
        newTopic.setId(UidUtil.gen());
        newTopic.setName(UidUtil.genName(TopicConstant.TOPIC_TYPE_P2P));

        topicMapper.insertTopic(newTopic);
        Subscriptions sub = new Subscriptions();
        sub.setCreateDat(new Timestamp(System.currentTimeMillis()));
        sub.setUpdateDat(sub.getCreateDat());
        sub.setUserId(userFrom);
        sub.setTopic(newTopic.getId());
        subMapper.insertSubscription(sub);
        sub.setUserId(userTo);
        subMapper.insertSubscription(sub);
        return newTopic.toString();
    }

    // 2. 新建群组topic
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public String subNewGroupTopic(long userFrom, MsgClientSub sub) {
        Topic topic = new Topic();
        topic.setOwner(userFrom);
        topic.setId(UidUtil.gen());
        topic.setName(UidUtil.genName(TopicConstant.TOPIC_TYPE_GRP));
        topicMapper.insertTopic(topic);

        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setUserId(userFrom);
        subscriptions.setTopic(topic.getId());
        subMapper.insertSubscription(subscriptions);
        return topic.toString();
    }

    // 3.订阅已有topic
    @Override
    public String subExistTopic(long userFrom, long topic) {

        return null;
    }


}
