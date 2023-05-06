package com.ligen.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;

public class Message {

    private int id;
    private Timestamp createDat;
    private Timestamp updateDat;
    private Timestamp deleteDat;
    private int delId;
    private int seqId; // 序号
    private long topic; // 属于哪个topic
    private long from; // 谁发送的
    private String head;
    private String content;

    public Message() {
        this.createDat = new Timestamp(System.currentTimeMillis());
        this.updateDat = this.createDat;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
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

    public int getDelId() {
        return delId;
    }

    public void setDelId(int delId) {
        this.delId = delId;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public long getTopic() {
        return topic;
    }

    public void setTopic(long topic) {
        this.topic = topic;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
