package com.ligen.entity.message.sub;

import java.util.Map;

public class MsgSetDesc {

    private MsgDefaultAcsMode defaultAcs; // defacs
    private Object trusted;
    private Object pub; // public
    private Object prvt; // private

    @Override
    public String toString() {
        return "MsgSetDesc{" +
                "defaultAcs=" + defaultAcs +
                ", trusted=" + trusted +
                ", pub=" + pub +
                ", prvt=" + prvt +
                '}';
    }

    public MsgDefaultAcsMode getDefaultAcs() {
        return defaultAcs;
    }

    public void setDefaultAcs(MsgDefaultAcsMode defaultAcs) {
        this.defaultAcs = defaultAcs;
    }

    public Object getTrusted() {
        return trusted;
    }

    public void setTrusted(Object trusted) {
        this.trusted = trusted;
    }

    public Object getPub() {
        return pub;
    }

    public void setPub(Object pub) {
        this.pub = pub;
    }

    public Object getPrvt() {
        return prvt;
    }

    public void setPrvt(Object prvt) {
        this.prvt = prvt;
    }
}
