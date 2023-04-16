package com.ligen.entity.message.server;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.sub.MsgAccessMode;
import com.ligen.entity.message.sub.MsgDelRange;

import java.util.ArrayList;
import java.util.List;

public class MsgServerPres {

    private String topic;
    private String src;
    private String what;
    private String userAgent;
    private int seqId;
    private int delId;
    private List<MsgDelRange> delSeq;
    private String acsTarget;
    private String acsActor;

    private MsgAccessMode acs;
    private boolean wantReply;
    private int filterIn;
    private int filterOut;
    private String skipTopic;
    private String singleUser;
    private String excludeUser;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
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

    public String getAcsTarget() {
        return acsTarget;
    }

    public void setAcsTarget(String acsTarget) {
        this.acsTarget = acsTarget;
    }

    public String getAcsActor() {
        return acsActor;
    }

    public void setAcsActor(String acsActor) {
        this.acsActor = acsActor;
    }

    public MsgAccessMode getAcs() {
        return acs;
    }

    public void setAcs(MsgAccessMode acs) {
        this.acs = acs;
    }

    public boolean isWantReply() {
        return wantReply;
    }

    public void setWantReply(boolean wantReply) {
        this.wantReply = wantReply;
    }

    public int getFilterIn() {
        return filterIn;
    }

    public void setFilterIn(int filterIn) {
        this.filterIn = filterIn;
    }

    public int getFilterOut() {
        return filterOut;
    }

    public void setFilterOut(int filterOut) {
        this.filterOut = filterOut;
    }

    public String getSkipTopic() {
        return skipTopic;
    }

    public void setSkipTopic(String skipTopic) {
        this.skipTopic = skipTopic;
    }

    public String getSingleUser() {
        return singleUser;
    }

    public void setSingleUser(String singleUser) {
        this.singleUser = singleUser;
    }

    public String getExcludeUser() {
        return excludeUser;
    }

    public void setExcludeUser(String excludeUser) {
        this.excludeUser = excludeUser;
    }
}
