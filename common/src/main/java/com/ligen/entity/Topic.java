package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;
import java.util.Map;

public class Topic {

    private long id;
    private Timestamp createDat;
    private Timestamp updateDat;
    private int state;
    private Timestamp stateAt;
    private Timestamp toucheDat;
    private String name;
    private int userBt;
    private long owner;
    private String access;
    private int seqId;
    private int delId;
    private Map<String, String> pub;
    private Map<String, String> trusted;
    private Map<String, String> tags;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Topic() {
        this.createDat = new Timestamp(System.currentTimeMillis());
        this.updateDat = this.createDat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreateDat() {
        return createDat;
    }

    public void setCreateDat(Timestamp createDat) {
        this.createDat = createDat;
    }

    public Timestamp getUpdateDat() {
        return updateDat;
    }

    public void setUpdateDat(Timestamp updateDat) {
        this.updateDat = updateDat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getStateAt() {
        return stateAt;
    }

    public void setStateAt(Timestamp stateAt) {
        this.stateAt = stateAt;
    }

    public Timestamp getToucheDat() {
        return toucheDat;
    }

    public void setToucheDat(Timestamp toucheDat) {
        this.toucheDat = toucheDat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserBt() {
        return userBt;
    }

    public void setUserBt(int userBt) {
        this.userBt = userBt;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}
