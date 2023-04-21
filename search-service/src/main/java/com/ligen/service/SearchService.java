package com.ligen.service;

import com.ligen.entity.User;

public interface SearchService {

    User searchUserByTag(String meth, String val);

    User searchUserById(String uid);

    long searchTopicByTag(String tags);

    long searchTopicById(String tid);
}
