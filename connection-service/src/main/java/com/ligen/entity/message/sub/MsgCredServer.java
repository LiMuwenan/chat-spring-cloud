package com.ligen.entity.message.sub;

public class MsgCredServer {

    private String method;
    private String value;
    private boolean done;

    @Override
    public String toString() {
        return "MsgCredServer{" +
                "method='" + method + '\'' +
                ", value='" + value + '\'' +
                ", done=" + done +
                '}';
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
