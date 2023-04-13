package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;

public class MsgClientLeave {

    private String id;
    private String topic;
    private boolean unsub; // 是否取消订阅会话

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

    public boolean isUnsub() {
        return unsub;
    }

    public void setUnsub(boolean unsub) {
        this.unsub = unsub;
    }
}
