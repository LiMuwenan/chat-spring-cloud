package com.ligen.util;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 产生uuid
 */
public class UidUtil {

    public static long gen() {
        LocalDateTime now = LocalDateTime.now();
        // 8 + 13 + 1
        String uid = now.toString().substring(2, 10).replaceAll("-", "") + System.currentTimeMillis();
        return Long.parseLong(uid);
    }
}
