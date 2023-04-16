package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.entity.message.sub.MsgDelRange;

import java.util.ArrayList;
import java.util.List;

public class MsgClientDel {

    private String id;
    private String topic;

    private String what;
    private List<MsgDelRange> delSeq;
    private String user;
    private MsgCredClient cred;
    private boolean Hard;

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

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public List<MsgDelRange> getDelSeq() {
        return delSeq;
    }

    public void setDelSeq(List<MsgDelRange> delSeq) {
        this.delSeq = delSeq;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public MsgCredClient getCred() {
        return cred;
    }

    public void setCred(MsgCredClient cred) {
        this.cred = cred;
    }

    public boolean isHard() {
        return Hard;
    }

    public void setHard(boolean hard) {
        Hard = hard;
    }
}
