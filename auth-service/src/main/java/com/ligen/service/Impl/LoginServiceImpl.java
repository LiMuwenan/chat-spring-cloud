package com.ligen.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.User;
import com.ligen.service.LoginService;
import com.ligen.service.client.UserServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserServiceClient userServiceClient;

    @Override
    public User register(String scheme, Map<String, String> pub, Map<String, String> tags, String secret) {
        String str = userServiceClient.registerNewUser(scheme,
                JSONObject.toJSONString(pub),
                JSONObject.toJSONString(tags),
                secret);
        User user = JSONObject.parseObject(str, User.class);
        LOGGER.info(user.toString());
        LOGGER.info(JSONObject.toJSONString(pub));
        return user;
    }

    @Override
    public boolean login(String scheme, String secret, String cred, String sessionId, String ip) {
        return userServiceClient.login(scheme, secret, cred, sessionId, ip);
    }
}
