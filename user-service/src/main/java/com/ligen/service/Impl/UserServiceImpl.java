package com.ligen.service.Impl;

import com.ligen.entity.Auth;
import com.ligen.entity.User;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.mapper.UserMapper;
import com.ligen.service.UserService;
import com.ligen.util.UidUtil;
import com.ligen.util.UserConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserByUserId(long uid) {
        return userMapper.selectUserByUserId(uid);
    }

    @Override
    public int insertUsersByList(List<User> userList) {
        return userMapper.insertUsersByList(userList);
    }

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
    public int deleteUsersByUserId(long uid, boolean hard) {
        return userMapper.deleteUsersByUserId(uid, hard);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }

    @Override
    public int insertUserTags(long uid, List<String> tags) {
        for (String tag : tags) {
            userMapper.insertUserTags(uid, tag);
        }
        return tags.size();
    }

    @Override
    public boolean loginBasic(String secret, String scheme, MsgCredClient cred) {
        String[] u = secret.split(":");
        long uid = userMapper.selectUserIdByCred(cred.getMeth()+":"+cred.getVal());
        Auth auth = userMapper.selectAuthByUserIdAndScheme(uid, "basic");
        return u[1].equals(auth.getSecret());
    }

}
