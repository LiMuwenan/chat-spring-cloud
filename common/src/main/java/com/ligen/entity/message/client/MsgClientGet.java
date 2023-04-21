package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgGetOpts;


public class MsgClientGet {

    private String id;
    private String topic;
    private String what;
    private MsgGetOpts desc;
    private MsgGetOpts sub;
    private MsgGetOpts data;
    private MsgGetOpts del;
    private MsgGetOpts tags;

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

    public MsgGetOpts getDesc() {
        return desc;
    }

    public void setDesc(MsgGetOpts desc) {
        this.desc = desc;
    }

    public MsgGetOpts getSub() {
        return sub;
    }

    public void setSub(MsgGetOpts sub) {
        this.sub = sub;
    }

    public MsgGetOpts getData() {
        return data;
    }

    public void setData(MsgGetOpts data) {
        this.data = data;
    }

    public MsgGetOpts getDel() {
        return del;
    }

    public void setDel(MsgGetOpts del) {
        this.del = del;
    }

    public MsgGetOpts getTags() {
        return tags;
    }

    public void setTags(MsgGetOpts tags) {
        this.tags = tags;
    }
}
