package com.ligen.entity.message.sub;

import java.time.LocalDateTime;

public class MsgLastSeenInfo {

    private LocalDateTime when;
    private String userAgent;

    @Override
    public String toString() {
        return "MsgLastSeenInfo{" +
                "when=" + when +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
