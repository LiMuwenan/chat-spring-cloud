package com.ligen.controller;

import com.ligen.serivce.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET, value = "/message/")
    public String receivePub(@RequestParam long topic,
                             @RequestParam long fromUser,
                             @RequestParam String content,
                             @RequestParam String head,
                             @RequestParam int seqId) {


        int newMessage = messageService.createNewMessage(topic,
                fromUser,
                content,
                head,
                seqId);

        if (newMessage != 0) {
            // 查询订阅该topic的人数，推送消息
            // 丢给rabbitmq

            return "发送成功";
        } else {
            return "丢掉消息";
        }

    }

}
