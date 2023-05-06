package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 发送聊天消息
 */
public class MsgClientPub {

    private String id;
    private long topic;
    private boolean noecho;
    private Map<String, String> head; // 标识消息类型
    private String content; // 消息内容，多媒体或者富文本为json格式

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

    public long getTopic() {
        return topic;
    }

    public void setTopic(long topic) {
        this.topic = topic;
    }

    public boolean isNoecho() {
        return noecho;
    }

    public void setNoecho(boolean noecho) {
        this.noecho = noecho;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public void setHead(Map<String, String> head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
