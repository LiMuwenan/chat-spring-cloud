package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.client.MsgClientSub;

import java.sql.Timestamp;
import java.util.Map;

public class Subscriptions {
    private int id;
    private Timestamp createDat;
    private Timestamp updateDat;
    private Timestamp deleteDat;
    private long userId;
    private long topic;
    private int delId;
    private int recvSeqId;
    private int readSeqId;
    private String modeWant;
    private String modeGiven;
    private Map<String, String> pvt;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Subscriptions() {
        this.createDat = new Timestamp(System.currentTimeMillis());
        this.updateDat = this.createDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreateDat() {
        return createDat;
    }

    public void setCreateDat(Timestamp createDat) {
        this.createDat = createDat;
    }

    public Timestamp getUpdateDat() {
        return updateDat;
    }

    public void setUpdateDat(Timestamp updateDat) {
        this.updateDat = updateDat;
    }

    public Timestamp getDeleteDat() {
        return deleteDat;
    }

    public void setDeleteDat(Timestamp deleteDat) {
        this.deleteDat = deleteDat;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTopic() {
        return topic;
    }

    public void setTopic(long topic) {
        this.topic = topic;
    }

    public int getDelId() {
        return delId;
    }

    public void setDelId(int delId) {
        this.delId = delId;
    }

    public int getRecvSeqId() {
        return recvSeqId;
    }

    public void setRecvSeqId(int recvSeqId) {
        this.recvSeqId = recvSeqId;
    }

    public int getReadSeqId() {
        return readSeqId;
    }

    public void setReadSeqId(int readSeqId) {
        this.readSeqId = readSeqId;
    }

    public String getModeWant() {
        return modeWant;
    }

    public void setModeWant(String modeWant) {
        this.modeWant = modeWant;
    }

    public String getModeGiven() {
        return modeGiven;
    }

    public void setModeGiven(String modeGiven) {
        this.modeGiven = modeGiven;
    }

    public Map<String, String> getPvt() {
        return pvt;
    }

    public void setPvt(Map<String, String> pvt) {
        this.pvt = pvt;
    }
}
