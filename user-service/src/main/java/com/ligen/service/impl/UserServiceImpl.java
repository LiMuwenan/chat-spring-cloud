package com.ligen.service.impl;

import com.ligen.entity.Auth;
import com.ligen.entity.SessionCache;
import com.ligen.entity.User;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.entity.message.sub.MsgGetOpts;
import com.ligen.mapper.UserMapper;
import com.ligen.service.UserService;
import com.ligen.util.CommonConstant;
import com.ligen.util.RedisKeyUtil;
import com.ligen.util.UidUtil;
import com.ligen.util.UserConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public User createNewUser(String scheme, Map<String, String> pub, Map<String, String> tags, String secret) {
        // 用户信息
        User user = new User();
        user.setId(UidUtil.gen());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(user.getCreatedAt());
        user.setPub(pub);
        user.setTags(tags);
        int count = userMapper.insertUser(user);
        Map<String, String> userTags = user.getTags();
        // 用户标签信息
        for (String key : userTags.keySet()) {
            userMapper.insertUserTags(user.getId(), key+":"+userTags.get(key));
        }
        // 用户密码信息
        String[] u = secret.split(":");
        userMapper.insertUserPassword(u[0], user.getId(), scheme,
                UserConstant.DEFAULT_AUTH_LVL,
                u[1]);


        return user;
    }

    @Override
    public long loginBasic(String secret, String scheme, MsgCredClient cred, String sessionId, String ip) {
        String[] u = secret.split(":");
        User user = userMapper.selectUser(cred.getMeth()+":"+cred.getVal(), CommonConstant.SEARCH_USER_TAG);
        Auth auth = userMapper.selectAuthByUserIdAndScheme(user.getId(), "basic");
        boolean isLogin = u[1].equals(auth.getSecret());
        // 登录成功，加入redis
        if (isLogin) {
            // online:{SessionCache}
            SessionCache cache = new SessionCache();
            cache.setIp(ip);
            cache.setUserId(user.getId());
            cache.setSessionId(sessionId);
            redisTemplate.opsForValue().set(RedisKeyUtil.onlineKey(user.getId()),sessionId,
                    CommonConstant.EXPIRED_TIME, TimeUnit.SECONDS);
            return user.getId();
        }
        return 0L;
    }

    @Override
    public User searchUser(String opts, int type) {
        User user = userMapper.selectUser(opts, type);
        LOGGER.info(user.toString());
        return user;
    }


}
