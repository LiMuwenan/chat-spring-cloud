package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgCredClient;

import java.util.ArrayList;
import java.util.List;

public class MsgClientLogin {

    private String id;
    private String scheme;
    private String secret;
    private List<MsgCredClient> cred;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<MsgCredClient> getCred() {
        return cred;
    }

    public void setCred(List<MsgCredClient> cred) {
        this.cred = cred;
    }
}
