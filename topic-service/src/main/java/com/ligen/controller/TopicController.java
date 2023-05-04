package com.ligen.controller;

import com.ligen.entity.Topic;
import com.ligen.service.TopicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TopicController {

    @Resource
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET, path = "/search/{opts}/{type}")
    public Topic searchTopic(@PathVariable String opts, @PathVariable int type) {
        return topicService.searchTopic(opts, type);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sub/")
    public String subNewTopic(@RequestParam("userFrom") long userFrom, @RequestParam("userTo") long userTo, @RequestParam("topic") String topic) {
        if (userTo == 0) {
            topicService.subNewGroupTopic(userFrom, null);
        } else {
            topicService.subNewP2PTopic(userFrom, userTo);
        }
        return "订阅成功";
    }

}
