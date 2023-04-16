package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;

public class Auth {

    private int id;
    private String uname;
    private long userId;
    private String scheme;
    private int authLvl;
    private String secret;
    private Timestamp expires;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public int getAuthLvl() {
        return authLvl;
    }

    public void setAuthLvl(int authLvl) {
        this.authLvl = authLvl;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Timestamp getExpires() {
        return expires;
    }

    public void setExpires(Timestamp expires) {
        this.expires = expires;
    }
}
