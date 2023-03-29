package com.ligen.entity.message.sub;

import java.util.List;

public class MsgDelValues {

    private int delId;
    private List<MsgDelRange> delSeq;

    @Override
    public String toString() {
        return "MsgDelValues{" +
                "delId=" + delId +
                ", delSeq=" + delSeq +
                '}';
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
