package com.ligen.entity.message.sub;

/**
 * set.sub {sub.what} == "sub"
 */
public class MsgSetSub {

    private String user;
    private String mode;

    @Override
    public String toString() {
        return "MsgSetSub{" +
                "user='" + user + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
