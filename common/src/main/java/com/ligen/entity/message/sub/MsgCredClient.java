package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MsgCredClient {

    private String meth;
    private String val;
    private String resp;
    private Map<String, String> params;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
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

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
