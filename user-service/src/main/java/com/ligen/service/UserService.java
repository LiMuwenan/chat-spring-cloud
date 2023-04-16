package com.ligen.service;

import com.ligen.entity.Auth;
import com.ligen.entity.User;
import com.ligen.entity.message.sub.MsgCredClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 通过userId查找一个确定用户
     *
     * @param uid
     * @return 返回一个确定的用户信息
     */
    public User selectUserByUserId(long uid);

    /**
     * 插入一组用户数据
     *
     * @param userList
     * @return 返回影响数据行数
     */
    public int insertUsersByList(List<User> userList);

    /**
     * 插入一条用户数据
     *
     * @return 返回创建的用户信息
     */
    public User createNewUser(String scheme, Map<String, String> pub, Map<String, String> tags, String secret);

    /**
     * 删除一个用户信息，通过uid
     *
     * @param uid
     * @param hard 是否软删除
     * @return 返回影响数据行数
     */
    public int deleteUsersByUserId(long uid, boolean hard);

    /**
     * 更新用户信息
     *
     * @param user
     * @return 返回影响数据行数
     */
    public int updateUserInfo(User user);

    /**
     * 新增一条用户标签
     * @param uid
     * @param tags
     * @return
     */
    public int insertUserTags(long uid, List<String> tags);

    /**
     * 登录
     * @return
     */
    public boolean loginBasic(String secret, String scheme, MsgCredClient cred, String sessionId, String ip);
}
