package com.ligen.mapper;

import com.ligen.entity.Subscriptions;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubMapper {

    /**
     * 插入一条订阅信息
     * @param sub
     * @return
     */
    int insertSubscription(Subscriptions sub);
}
