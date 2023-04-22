package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.entity.message.sub.MsgSetDesc;
import com.ligen.entity.message.sub.MsgSetSub;

import java.util.List;

public class MsgClientSet {

    private String id;
    private String topic;
    private MsgSetDesc desc;
    private MsgSetSub sub;
    private List<String> tags;
    private MsgCredClient cred;

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

    public MsgSetDesc getDesc() {
        return desc;
    }

    public void setDesc(MsgSetDesc desc) {
        this.desc = desc;
    }

    public MsgSetSub getSub() {
        return sub;
    }

    public void setSub(MsgSetSub sub) {
        this.sub = sub;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public MsgCredClient getCred() {
        return cred;
    }

    public void setCred(MsgCredClient cred) {
        this.cred = cred;
    }
}
