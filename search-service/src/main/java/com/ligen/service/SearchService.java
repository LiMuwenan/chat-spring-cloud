package com.ligen.service;

import com.ligen.entity.Topic;
import com.ligen.entity.User;

public interface SearchService {

    User searchUserByTag(String meth, String val);

    User searchUserById(String uid);

    Topic searchTopicByTag(String val);

    Topic searchTopicById(String tid);
}
