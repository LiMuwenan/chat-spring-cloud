package com.ligen.util;

/**
 * 通用的一些常量
 */
public interface CommonConstant {

    /**
     * websocket连接过期时间，客户端没有给服务端发送消息，即认为断开连接
     * 单位：秒
     */
    int EXPIRED_TIME = 300;

    /**
     * 消息包中what字段的信息
     */
    String WHAT_DESC = "desc";
    String WHAT_TAGS = "tags";
    String WHAT_DEL = "del";
    String WHAT_SUB = "sub";
    String WHAT_DATA = "data";
    String WHAT_CRED = "cred";

    /**
     * 搜索类型
     */
    int SEARCH_USER_ID = 1;
    int SEARCH_USER_TAG = 2;
    int SEARCH_TOPIC_TAG = 3;
    int SEARCH_TOPIC_ID = 4;
}
