package com.ligen.entity.message.sub;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MsgDelValues {

    private int delId;
    private List<MsgDelRange> delSeq;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public int getDelId() {
        return delId;
    }

    public void setDelId(int delId) {
        this.delId = delId;
    }

    public List<MsgDelRange> getDelSeq() {
        return delSeq;
    }

    public void setDelSeq(List<MsgDelRange> delSeq) {
        this.delSeq = delSeq;
    }
}
