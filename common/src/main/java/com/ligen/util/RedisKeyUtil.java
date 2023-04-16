package com.ligen.util;

/**
 * 拼接redis key
 */
public class RedisKeyUtil {

    private static final String ONLINE = "online";

    public static String onlineKey(String str) {
        return ONLINE;
    }
}
