package com.ligen.entity.message.server;

import com.alibaba.fastjson.JSONObject;

public class MsgServerInfo {

    private String topic;
    private String src;
    private String from;
    private String what;
    private int seqId;
    private String skipTopic;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public String getSkipTopic() {
        return skipTopic;
    }

    public void setSkipTopic(String skipTopic) {
        this.skipTopic = skipTopic;
    }
}
