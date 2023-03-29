package com.ligen.entity.message;

import com.ligen.entity.message.server.*;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;

public class ServerComMessage {

    private MsgServerCtrl ctrl;
    private MsgServerData data;
    private MsgServerMeta meta;
    private MsgServerPres pres;
    private MsgServerInfo info;

    private String id;
    private String rcptTo;
    private String asUser;
    private LocalDateTime TimeStamp;
    private WebSocketSession session;

    private String skipSid;
    private long uid;

    @Override
    public String toString() {
        return "ServerComMessage{" +
                "ctrl=" + ctrl +
                ", data=" + data +
                ", meta=" + meta +
                ", pres=" + pres +
                ", info=" + info +
                ", id='" + id + '\'' +
                ", rcptTo='" + rcptTo + '\'' +
                ", asUser='" + asUser + '\'' +
                ", TimeStamp=" + TimeStamp +
                ", session=" + session +
                ", skipSid='" + skipSid + '\'' +
                ", uid=" + uid +
                '}';
    }

    public MsgServerCtrl getCtrl() {
        return ctrl;
    }

    public void setCtrl(MsgServerCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public MsgServerData getData() {
        return data;
    }

    public void setData(MsgServerData data) {
        this.data = data;
    }

    public MsgServerMeta getMeta() {
        return meta;
    }

    public void setMeta(MsgServerMeta meta) {
        this.meta = meta;
    }

    public MsgServerPres getPres() {
        return pres;
    }

    public void setPres(MsgServerPres pres) {
        this.pres = pres;
    }

    public MsgServerInfo getInfo() {
        return info;
    }

    public void setInfo(MsgServerInfo info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRcptTo() {
        return rcptTo;
    }

    public void setRcptTo(String rcptTo) {
        this.rcptTo = rcptTo;
    }

    public String getAsUser() {
        return asUser;
    }

    public void setAsUser(String asUser) {
        this.asUser = asUser;
    }

    public LocalDateTime getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        TimeStamp = timeStamp;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public String getSkipSid() {
        return skipSid;
    }

    public void setSkipSid(String skipSid) {
        this.skipSid = skipSid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
