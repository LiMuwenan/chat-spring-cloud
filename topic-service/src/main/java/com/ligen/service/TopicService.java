package com.ligen.service;

import com.ligen.entity.Subscriptions;
import com.ligen.entity.Topic;
import com.ligen.entity.message.client.MsgClientSub;

public interface TopicService {

    Topic searchTopic(String opts, int type);

    /**
     * 订阅一个topic
     * 1、用户新建两个人之间的topic。需要两个用户的信息
     * @return
     */
    String subNewP2PTopic(long userFrom, long userTo);

    /**
     * 订阅一个topic
     * 2、用户新建群组topic，需要userFrom和topic信息
     * @return
     */
    String subNewGroupTopic(long userFrom, MsgClientSub sub);

    /**
     * 订阅一个topic
     * 3、用户订阅一个已经存在的群组topic，需要userFrom和topic
     * @return
     */
    String subExistTopic(long userFrom, long topic);
}
