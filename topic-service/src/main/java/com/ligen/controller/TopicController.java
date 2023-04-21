package com.ligen.controller;

import com.ligen.entity.Topic;
import com.ligen.service.TopicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TopicController {

    @Resource
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET, path = "/search/{opts}/{type}")
    public Topic searchTopic(@PathVariable String opts, @PathVariable int type) {
        return topicService.searchTopic(opts, type);
    }

}
