package com.ligen.entity.message.server;

import java.time.LocalDateTime;
import java.util.Map;

public class MsgServerCtrl {

    private String id;
    private String topic;
    private Map<String, String> params;

    private int code;
    private String text;
    private LocalDateTime timeStamp;

    @Override
    public String toString() {
        return "MsgClientCtrl{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", params=" + params +
                ", code=" + code +
                ", text='" + text + '\'' +
                ", timeStamp=" + timeStamp +
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

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
