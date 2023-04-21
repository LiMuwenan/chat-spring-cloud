package com.ligen.mapper;

import com.ligen.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {

    Topic selectTopic(String opts, int type);
}
