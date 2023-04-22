package com.ligen.service.impl;

import com.ligen.entity.Topic;
import com.ligen.mapper.TopicMapper;
import com.ligen.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopicServiceImpl implements TopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Resource
    private TopicMapper topicMapper;

    @Override
    public Topic searchTopic(String opts, int type) {
        Topic topic = topicMapper.selectTopic(opts, type);
        LOGGER.info(topic.toString());
        return topic;
    }
}
