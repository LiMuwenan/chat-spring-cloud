package com.ligen.serivce;

public interface MessageService {

    int createNewMessage(long topic, long fromUser, String content, String head, int seqId);
}
