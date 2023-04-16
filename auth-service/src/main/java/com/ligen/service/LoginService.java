package com.ligen.service;

import com.ligen.entity.User;

import java.util.List;
import java.util.Map;

public interface LoginService {

    /**
     * 注册一个用户
     * @param scheme
     * @param pub
     * @return
     */
    User register(String scheme, Map<String, String> pub, Map<String, String> tags, String secret);

    /**
     * 一个用户登录
     * @param scheme
     * @param secret
     * @return
     */
    boolean login(String scheme, String secret, String cred, String sessionId, String ip);
}
