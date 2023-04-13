package com.ligen.entity.message.client;

import com.alibaba.fastjson.JSONObject;

/**
 * 连接时发送本消息
 */
public class MsgClientHi {

    private String id;
    private String ver;
    private String ua; // user agent
    private String dev; // device
    private String platform;
    private String lang;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public MsgClientHi() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


}
