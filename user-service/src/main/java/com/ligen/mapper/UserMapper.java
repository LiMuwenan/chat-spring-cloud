package com.ligen.mapper;

import com.ligen.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

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
     * 插入一条用户信息
     *
     * @param user
     * @return 返回影响数据行数
     */
    public int insertUser(User user);

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
     * @param tag
     * @return
     */
    public int insertUserTags(long uid, String tag);

    /**
     * 新增一条用户密码
     * @return
     */
    public int insertUserPassword(String uname, long userid, String scheme, int authLvl, String secret);
    public int insertUserPassword(String uname, long userid);
}
