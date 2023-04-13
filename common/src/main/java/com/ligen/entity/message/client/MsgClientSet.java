package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgSetQuery;

public class MsgClientSet {

    private String id;
    private String topic;
    private MsgSetQuery setQuery;

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

    public MsgSetQuery getSetQuery() {
        return setQuery;
    }

    public void setSetQuery(MsgSetQuery setQuery) {
        this.setQuery = setQuery;
    }
}
