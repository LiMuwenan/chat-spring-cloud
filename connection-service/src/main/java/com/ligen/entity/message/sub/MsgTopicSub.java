package com.ligen.entity.message.sub;

import java.time.LocalDateTime;

public class MsgTopicSub {

    private LocalDateTime updateAt;
    private LocalDateTime DeletedAt;

    private boolean online;
    private MsgAccessMode acs;
    private int readSeqId;
    private int RecvSeqId;
    private Object pub;
    private Object trusted;
    private Object prvt; // private

    private String user;
    private String topic;
    private LocalDateTime touchedAt;
    private int seqId;
    private int delId;

    private MsgLastSeenInfo lastSeen;

    @Override
    public String toString() {
        return "MsgTopicSub{" +
                "updateAt=" + updateAt +
                ", DeletedAt=" + DeletedAt +
                ", online=" + online +
                ", acs=" + acs +
                ", readSeqId=" + readSeqId +
                ", RecvSeqId=" + RecvSeqId +
                ", pub=" + pub +
                ", trusted=" + trusted +
                ", prvt=" + prvt +
                ", user='" + user + '\'' +
                ", topic='" + topic + '\'' +
                ", touchedAt=" + touchedAt +
                ", seqId=" + seqId +
                ", delId=" + delId +
                ", lastSeen=" + lastSeen +
                '}';
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getDeletedAt() {
        return DeletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        DeletedAt = deletedAt;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public MsgAccessMode getAcs() {
        return acs;
    }

    public void setAcs(MsgAccessMode acs) {
        this.acs = acs;
    }

    public int getReadSeqId() {
        return readSeqId;
    }

    public void setReadSeqId(int readSeqId) {
        this.readSeqId = readSeqId;
    }

    public int getRecvSeqId() {
        return RecvSeqId;
    }

    public void setRecvSeqId(int recvSeqId) {
        RecvSeqId = recvSeqId;
    }

    public Object getPub() {
        return pub;
    }

    public void setPub(Object pub) {
        this.pub = pub;
    }

    public Object getTrusted() {
        return trusted;
    }

    public void setTrusted(Object trusted) {
        this.trusted = trusted;
    }

    public Object getPrvt() {
        return prvt;
    }

    public void setPrvt(Object prvt) {
        this.prvt = prvt;
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

    public LocalDateTime getTouchedAt() {
        return touchedAt;
    }

    public void setTouchedAt(LocalDateTime touchedAt) {
        this.touchedAt = touchedAt;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public int getDelId() {
        return delId;
    }

    public void setDelId(int delId) {
        this.delId = delId;
    }

    public MsgLastSeenInfo getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(MsgLastSeenInfo lastSeen) {
        this.lastSeen = lastSeen;
    }
}
