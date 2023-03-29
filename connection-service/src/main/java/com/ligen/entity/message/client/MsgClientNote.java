package com.ligen.entity.message.client;

public class MsgClientNote {

    private String topic;
    private String what;
    private int seqId;
    private int unread;

    @Override
    public String toString() {
        return "MsgClientNote{" +
                "topic='" + topic + '\'' +
                ", what='" + what + '\'' +
                ", seqId=" + seqId +
                ", unread=" + unread +
                '}';
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

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }
}
