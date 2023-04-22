package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;

public class MsgClientSub {

    private String id;
    private String topic;
    private MsgClientSet set;
    private MsgClientGet get;

    private boolean created;
    private boolean newSub;

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

    public MsgClientSet getSet() {
        return set;
    }

    public void setSet(MsgClientSet set) {
        this.set = set;
    }

    public MsgClientGet getGet() {
        return get;
    }

    public void setGet(MsgClientGet get) {
        this.get = get;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isNewSub() {
        return newSub;
    }

    public void setNewSub(boolean newSub) {
        this.newSub = newSub;
    }
}
