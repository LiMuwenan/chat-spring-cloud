package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;

public class MsgSetDesc {

    @JSONField(name = "defacs")
    private MsgDefaultAcsMode defaultAcs; // defacs
    private Map<String, String> trusted;
    @JSONField(name = "public")
    private Map<String, String> pub; // public
    @JSONField(name = "private")
    private Map<String, String> prvt; // private

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public MsgDefaultAcsMode getDefaultAcs() {
        return defaultAcs;
    }

    public void setDefaultAcs(MsgDefaultAcsMode defaultAcs) {
        this.defaultAcs = defaultAcs;
    }

    public Map<String, String> getTrusted() {
        return trusted;
    }

    public void setTrusted(Map<String, String> trusted) {
        this.trusted = trusted;
    }

    public Map<String, String> getPub() {
        return pub;
    }

    public void setPub(Map<String, String> pub) {
        this.pub = pub;
    }

    public Map<String, String> getPrvt() {
        return prvt;
    }

    public void setPrvt(Map<String, String> prvt) {
        this.prvt = prvt;
    }
}
