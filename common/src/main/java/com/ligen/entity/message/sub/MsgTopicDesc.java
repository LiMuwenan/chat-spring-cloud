package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
    private Map<String, String> pub;
    private Map<String, String> trusted;
    private Map<String, String> prvt; // private

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
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

    public Map<String, String> getPub() {
        return pub;
    }

    public void setPub(Map<String, String> pub) {
        this.pub = pub;
    }

    public Map<String, String> getTrusted() {
        return trusted;
    }

    public void setTrusted(Map<String, String> trusted) {
        this.trusted = trusted;
    }

    public Map<String, String> getPrvt() {
        return prvt;
    }

    public void setPrvt(Map<String, String> prvt) {
        this.prvt = prvt;
    }
}
