package com.ligen.entity.message.sub;

/**
 * 保存已删除消息的序号范围
 */
public class MsgDelRange {

    private int lowId;
    private int highId;

    @Override
    public String toString() {
        return "MsgDelRange{" +
                "lowId=" + lowId +
                ", highId=" + highId +
                '}';
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
