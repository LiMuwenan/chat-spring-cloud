package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.entity.message.sub.MsgSetDesc;

import java.util.List;
import java.util.Map;

public class MsgClientAcc {

    private String id;
    private String user;
    private String token;
    private String status;
    private String scheme; // 认证模式
    private String secret;
    private boolean login; // 是否登录
    private Map<String, String> tags; // 标签信息，供搜索用
    private MsgSetDesc desc; // 描述信息
    private List<MsgCredClient> cred; // 名片信息

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public MsgSetDesc getDesc() {
        return desc;
    }

    public void setDesc(MsgSetDesc desc) {
        this.desc = desc;
    }

    public List<MsgCredClient> getCred() {
        return cred;
    }

    public void setCred(List<MsgCredClient> cred) {
        this.cred = cred;
    }
}
