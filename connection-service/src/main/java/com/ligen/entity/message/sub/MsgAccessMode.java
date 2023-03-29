package com.ligen.entity.message.sub;

public class MsgAccessMode {

    private String want;
    private String given;
    private String mode;

    @Override
    public String toString() {
        return "MsgAccessMode{" +
                "want='" + want + '\'' +
                ", given='" + given + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
