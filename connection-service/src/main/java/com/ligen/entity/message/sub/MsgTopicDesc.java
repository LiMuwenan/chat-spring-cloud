package com.ligen.entity.message.sub;

import java.time.LocalDateTime;

public class MsgTopicDesc {

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LocalDateTime touchedAt;

    private String state;
    private boolean online;
    private boolean isChan;

    private MsgLastSeenInfo lastSeen;
    private MsgDefaultAcsMode defaultAcs;
    private int seqId;
    private int readSeqId;
    private int RecvSeqId;
    private int DelId;
    private Object pub;
    private Object trusted;
    private Object prvt; // private

    @Override
    public String toString() {
        return "MsgTopicDesc{" +
                "createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", touchedAt=" + touchedAt +
                ", state='" + state + '\'' +
                ", online=" + online +
                ", isChan=" + isChan +
                ", lastSeen=" + lastSeen +
                ", defaultAcs=" + defaultAcs +
                ", seqId=" + seqId +
                ", readSeqId=" + readSeqId +
                ", RecvSeqId=" + RecvSeqId +
                ", DelId=" + DelId +
                ", pub=" + pub +
                ", trusted=" + trusted +
                ", prvt=" + prvt +
                '}';
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getTouchedAt() {
        return touchedAt;
    }

    public void setTouchedAt(LocalDateTime touchedAt) {
        this.touchedAt = touchedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isChan() {
        return isChan;
    }

    public void setChan(boolean chan) {
        isChan = chan;
    }

    public MsgLastSeenInfo getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(MsgLastSeenInfo lastSeen) {
        this.lastSeen = lastSeen;
    }

    public MsgDefaultAcsMode getDefaultAcs() {
        return defaultAcs;
    }

    public void setDefaultAcs(MsgDefaultAcsMode defaultAcs) {
        this.defaultAcs = defaultAcs;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
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

    public int getDelId() {
        return DelId;
    }

    public void setDelId(int delId) {
        DelId = delId;
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
}
