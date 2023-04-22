package com.ligen.mapper;

import com.ligen.entity.Auth;
import com.ligen.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 通过用户id或者tag搜索用户信息
     *
     * @param opts 1为uid，2tag
     * @param type 1用id查用户表，2用tag查tag表
     * @return 返回一个确定的用户信息，后期扩展为返回一个列表
     */
    public User selectUser(String opts, int type);

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

    /**
     * 根据scheme和用户id查询用户认证信息
     * @param uid
     * @param scheme
     * @return
     */
    public Auth selectAuthByUserIdAndScheme(long uid, String scheme);

}
