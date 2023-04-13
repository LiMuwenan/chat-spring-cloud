package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

public class MsgGetQuery {

    private String what;
    private MsgGetOpts desc;
    private MsgGetOpts sub;
    private MsgGetOpts data;
    private MsgGetOpts del;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public MsgGetOpts getDesc() {
        return desc;
    }

    public void setDesc(MsgGetOpts desc) {
        this.desc = desc;
    }

    public MsgGetOpts getSub() {
        return sub;
    }

    public void setSub(MsgGetOpts sub) {
        this.sub = sub;
    }

    public MsgGetOpts getData() {
        return data;
    }

    public void setData(MsgGetOpts data) {
        this.data = data;
    }

    public MsgGetOpts getDel() {
        return del;
    }

    public void setDel(MsgGetOpts del) {
        this.del = del;
    }
}
