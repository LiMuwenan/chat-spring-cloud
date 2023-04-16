package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgGetQuery;


public class MsgClientGet {

    private String id;
    private String topic;
    private MsgGetQuery getQuery; // 查询条件

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public MsgGetQuery getGetQuery() {
        return getQuery;
    }

    public void setGetQuery(MsgGetQuery getQuery) {
        this.getQuery = getQuery;
    }
}
