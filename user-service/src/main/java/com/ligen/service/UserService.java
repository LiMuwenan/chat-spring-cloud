package com.ligen.service;

import com.ligen.entity.User;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.entity.message.sub.MsgGetOpts;

import java.util.Map;

public interface UserService {

    /**
     * 插入一条用户数据
     *
     * @return 返回创建的用户信息
     */
    public User createNewUser(String scheme, Map<String, String> pub, Map<String, String> tags, String secret);


    /**
     * 登录
     * @return
     */
    public long loginBasic(String secret, String scheme, MsgCredClient cred, String sessionId, String ip);

    public User searchUser(String opts, int type);
}
