package com.ligen.entity.message.sub;

public class MsgDefaultAcsMode {

    private String auth;
    private String anon;

    @Override
    public String toString() {
        return "Permission{" +
                "auth='" + auth + '\'' +
                ", anon='" + anon + '\'' +
                '}';
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getAnon() {
        return anon;
    }

    public void setAnon(String anon) {
        this.anon = anon;
    }
}
