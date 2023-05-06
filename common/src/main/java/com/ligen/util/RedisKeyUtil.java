package com.ligen.util;

/**
 * 拼接redis key
 */
public class RedisKeyUtil {

    private static final String ONLINE = "online";
    private static final String ALIVE = "alive";
    private static final String MSG_SEQ = "msgseq";

    public static String onlineKey(long uid) {
        return ONLINE + ":" + uid;
    }

    public static String aliveKey(String sessionId) {
        return ALIVE + ":" + sessionId;
    }

    public static String msgSeqKey(long topic) { return MSG_SEQ + ":" + topic;}
}
