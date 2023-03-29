package com.ligen.entity.message.server;

import java.time.LocalDateTime;
import java.util.Map;

public class MsgServerData {

    private String topic;
    private String from;
    private LocalDateTime timeStamp;
    private LocalDateTime deletedAt;
    private int seqId;
    private Map<String, String> head;
    private Object content;

    @Override
    public String toString() {
        return "MsgClientData{" +
                "topic='" + topic + '\'' +
                ", from='" + from + '\'' +
                ", timeStamp=" + timeStamp +
                ", deletedAt=" + deletedAt +
                ", seqId=" + seqId +
                ", head=" + head +
                ", content=" + content +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public void setHead(Map<String, String> head) {
        this.head = head;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
