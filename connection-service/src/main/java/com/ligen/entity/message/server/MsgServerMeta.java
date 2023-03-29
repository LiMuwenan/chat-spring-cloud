package com.ligen.entity.message.server;

import com.ligen.entity.message.sub.MsgCredServer;
import com.ligen.entity.message.sub.MsgDelValues;
import com.ligen.entity.message.sub.MsgTopicDesc;
import com.ligen.entity.message.sub.MsgTopicSub;

import java.time.LocalDateTime;
import java.util.List;

public class MsgServerMeta {

    private String id;
    private String topic;
    private LocalDateTime timeStamp;

    private MsgTopicDesc desc;
    private List<MsgTopicSub> sub;
    private MsgDelValues del;
    private List<String> tags;
    private List<MsgCredServer> cred;

    @Override
    public String toString() {
        return "MsgClientMeta{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", timeStamp=" + timeStamp +
                ", desc=" + desc +
                ", sub=" + sub +
                ", del=" + del +
                ", tags=" + tags +
                ", cred=" + cred +
                '}';
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public MsgTopicDesc getDesc() {
        return desc;
    }

    public void setDesc(MsgTopicDesc desc) {
        this.desc = desc;
    }

    public List<MsgTopicSub> getSub() {
        return sub;
    }

    public void setSub(List<MsgTopicSub> sub) {
        this.sub = sub;
    }

    public MsgDelValues getDel() {
        return del;
    }

    public void setDel(MsgDelValues del) {
        this.del = del;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<MsgCredServer> getCred() {
        return cred;
    }

    public void setCred(List<MsgCredServer> cred) {
        this.cred = cred;
    }
}
