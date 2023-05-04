package com.ligen.mapper;

import com.ligen.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {

    /**
     * 根据id、标签查询一个topic
     * @param opts
     * @param type
     * @return
     */
    Topic selectTopic(String opts, int type);

    /**
     * 插入一个topic
     * @param topic
     * @return
     */
    int insertTopic(Topic topic);

    /**
     * 更新一个topic。
     * 更新消息seqId
     * 更新public信息
     * @param topic
     * @return
     */
    int updateTopic(Topic topic);
}
