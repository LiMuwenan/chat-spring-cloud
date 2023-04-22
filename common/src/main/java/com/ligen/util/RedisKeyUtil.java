package com.ligen.util;

/**
 * 拼接redis key
 */
public class RedisKeyUtil {

    private static final String ONLINE = "online";
    private static final String ALIVE = "alive";

    public static String onlineKey(long uid) {
        return ONLINE + ":" + uid;
    }

    public static String aliveKey(String sessionId) {
        return ALIVE + ":" + sessionId;
    }
}
