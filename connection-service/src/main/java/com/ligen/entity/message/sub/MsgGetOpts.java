package com.ligen.entity.message.sub;

import java.time.LocalDateTime;
import java.util.Date;

public class MsgGetOpts {

    private String user;
    private String topic;
    private LocalDateTime date;
    private int sinceId;
    private int beforeId;
    private int limit;

    @Override
    public String toString() {
        return "MsgGetOpts{" +
                "user='" + user + '\'' +
                ", topic='" + topic + '\'' +
                ", date=" + date +
                ", sinceId=" + sinceId +
                ", beforeId=" + beforeId +
                ", limit=" + limit +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getSinceId() {
        return sinceId;
    }

    public void setSinceId(int sinceId) {
        this.sinceId = sinceId;
    }

    public int getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(int beforeId) {
        this.beforeId = beforeId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
