package com.ligen.service.client;

import com.ligen.entity.Topic;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("topic-service")
public interface TopicServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/search/{opts}/{type}")
    @LoadBalanced
    Topic searchTopic(@PathVariable String opts, @PathVariable int type);
}
