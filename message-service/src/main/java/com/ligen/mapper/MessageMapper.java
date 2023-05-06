package com.ligen.mapper;

import com.ligen.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    int insertMessage(Message message);

    Message selectMessageById(int id);

    List<Message> selectMessageByTopic(long topicId);
}
