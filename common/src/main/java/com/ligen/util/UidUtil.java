package com.ligen.util;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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

    /**
     * 生成topic的name
     * @param type 1、p2p，15位 2、grp25位
     * @return
     */
    public static String genName(int type) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        if (type == 1) {
            return TopicConstant.TOPIC_NAME_P2P + uuid.substring(0, 12);
        } else {
            return TopicConstant.TOPIC_NAME_GRP + uuid.substring(0, 22);
        }
    }
}
