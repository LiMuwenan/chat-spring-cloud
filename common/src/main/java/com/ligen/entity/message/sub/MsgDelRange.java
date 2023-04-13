package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

/**
 * 保存已删除消息的序号范围
 */
public class MsgDelRange {

    private int lowId;
    private int highId;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public int getLowId() {
        return lowId;
    }

    public void setLowId(int lowId) {
        this.lowId = lowId;
    }

    public int getHighId() {
        return highId;
    }

    public void setHighId(int highId) {
        this.highId = highId;
    }
}
