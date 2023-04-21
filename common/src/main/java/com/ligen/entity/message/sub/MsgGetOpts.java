package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.Date;

public class MsgGetOpts {

    /**
     * 查询条件
     * 1、标签查用户：meth val
     * 2、id查用户： user
     * 3、标签查topic：topic val
     * 4、id查topic： topic
     */

    private String user; // base64
    private String topic;
    private LocalDateTime date;
    private int sinceId;
    private int beforeId;
    private int limit;
    private String meth;
    private String val;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getSinceId() {
        return sinceId;
    }

    public void setSinceId(int sinceId) {
        this.sinceId = sinceId;
    }

    public int getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(int beforeId) {
        this.beforeId = beforeId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getMeth() {
        return meth;
    }

    public void setMeth(String meth) {
        this.meth = meth;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
