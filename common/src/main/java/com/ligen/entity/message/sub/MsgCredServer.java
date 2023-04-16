package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

public class MsgCredServer {

    private String method;
    private String value;
    private boolean done;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
