package com.ligen.entity.message;

import com.ligen.entity.message.client.*;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;

public class ClientComMessage {

    private MsgClientHi hi;
    private MsgClientAcc acc;
    private MsgClientLogin login;
    private MsgClientSub sub;
    private MsgClientLeave leave;
    private MsgClientPub pub;
    private MsgClientGet get;
    private MsgClientSet set;
    private MsgClientDel del;
    private MsgClientNote note;

    private String id; // message id
    private String original; // from xxx topic
    private String rcptTo;
    private String asUser; // from user
    private int authLvl;
    private int metaWhat;
    private LocalDateTime timestamp;

    private WebSocketSession session;
    private boolean init;

    @Override
    public String toString() {
        return "ClientComMessage{" +
                "hi=" + hi +
                ", acc=" + acc +
                ", login=" + login +
                ", sub=" + sub +
                ", leave=" + leave +
                ", pub=" + pub +
                ", get=" + get +
                ", set=" + set +
                ", del=" + del +
                ", note=" + note +
                ", id='" + id + '\'' +
                ", original='" + original + '\'' +
                ", rcptTo='" + rcptTo + '\'' +
                ", asUser='" + asUser + '\'' +
                ", authLvl=" + authLvl +
                ", metaWhat=" + metaWhat +
                ", timestamp=" + timestamp +
                ", init=" + init +
                '}';
    }

    public MsgClientHi getHi() {
        return hi;
    }

    public void setHi(MsgClientHi hi) {
        this.hi = hi;
    }

    public MsgClientAcc getAcc() {
        return acc;
    }

    public void setAcc(MsgClientAcc acc) {
        this.acc = acc;
    }

    public MsgClientLogin getLogin() {
        return login;
    }

    public void setLogin(MsgClientLogin login) {
        this.login = login;
    }

    public MsgClientSub getSub() {
        return sub;
    }

    public void setSub(MsgClientSub sub) {
        this.sub = sub;
    }

    public MsgClientLeave getLeave() {
        return leave;
    }

    public void setLeave(MsgClientLeave leave) {
        this.leave = leave;
    }

    public MsgClientPub getPub() {
        return pub;
    }

    public void setPub(MsgClientPub pub) {
        this.pub = pub;
    }

    public MsgClientGet getGet() {
        return get;
    }

    public void setGet(MsgClientGet get) {
        this.get = get;
    }

    public MsgClientSet getSet() {
        return set;
    }

    public void setSet(MsgClientSet set) {
        this.set = set;
    }

    public MsgClientDel getDel() {
        return del;
    }

    public void setDel(MsgClientDel del) {
        this.del = del;
    }

    public MsgClientNote getNote() {
        return note;
    }

    public void setNote(MsgClientNote note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
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

    public int getAuthLvl() {
        return authLvl;
    }

    public void setAuthLvl(int authLvl) {
        this.authLvl = authLvl;
    }

    public int getMetaWhat() {
        return metaWhat;
    }

    public void setMetaWhat(int metaWhat) {
        this.metaWhat = metaWhat;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }
}
