package com.ligen.service.impl;

import com.ligen.entity.Topic;
import com.ligen.entity.User;
import com.ligen.service.SearchService;
import com.ligen.service.client.TopicServiceClient;
import com.ligen.service.client.UserServiceClient;
import com.ligen.util.CommonConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private UserServiceClient userClient;

    @Resource
    private TopicServiceClient topicClient;

    @Override
    public User searchUserByTag(String meth, String val) {
        return userClient.searchUser(meth+":"+val, CommonConstant.SEARCH_USER_TAG);
    }

    @Override
    public User searchUserById(String uid) {
        return userClient.searchUser(uid, CommonConstant.SEARCH_USER_ID);
    }

    @Override
    public Topic searchTopicByTag(String val) {
        return topicClient.searchTopic(val, CommonConstant.SEARCH_TOPIC_TAG);
    }

    @Override
    public Topic searchTopicById(String tid) {
        return topicClient.searchTopic(tid, CommonConstant.SEARCH_TOPIC_ID);
    }
}
