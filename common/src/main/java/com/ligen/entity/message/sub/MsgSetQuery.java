package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MsgSetQuery {

    private MsgSetDesc desc;
    private MsgSetSub sub;
    private List<String> tags;
    private MsgCredClient cred;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
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
