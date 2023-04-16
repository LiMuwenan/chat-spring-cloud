package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

/**
 * set.sub {sub.what} == "sub"
 */
public class MsgSetSub {

    private String user;
    private String mode;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
