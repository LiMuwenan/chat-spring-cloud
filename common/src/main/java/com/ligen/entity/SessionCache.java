package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;

public class SessionCache {
    private long userId;
    private String ip;
    private String sessionId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
