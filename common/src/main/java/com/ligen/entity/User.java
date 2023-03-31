package com.ligen.entity;

import java.sql.Timestamp;
import java.util.List;

public class User {

    private long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int state;
    private Timestamp stateAt;
    private int anon;
    private int auth;
    private Timestamp lastSeen;
    private String userAgent;
    private Object pub;
    private Object trusted;
    private List<String> tags;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", state=" + state +
                ", stateAt=" + stateAt +
                ", anon=" + anon +
                ", auth=" + auth +
                ", lastSeen=" + lastSeen +
                ", userAgent='" + userAgent + '\'' +
                ", pub=" + pub +
                ", trusted=" + trusted +
                ", tags=" + tags +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
