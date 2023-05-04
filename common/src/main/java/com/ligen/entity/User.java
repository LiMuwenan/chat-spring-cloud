package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;
import java.util.Map;

public class User {

    private long id;
    private Timestamp createDat;
    private Timestamp updateDat;
    private int state;
    private Timestamp stateAt;
    private int anon;
    private int auth;
    private Timestamp lastSeen;
    private String userAgent;
    private Map<String, String> pub;
    private Map<String, String> trusted;
    private Map<String, String> tags;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public User() {
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

    public int getAnon() {
        return anon;
    }

    public void setAnon(int anon) {
        this.anon = anon;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Timestamp lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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
