package com.ligen.service.Impl;

import com.ligen.entity.User;
import com.ligen.mapper.UserMapper;
import com.ligen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public int deleteUsersByUserId(long uid, boolean hard) {
        return userMapper.deleteUsersByUserId(uid, hard);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }
}
