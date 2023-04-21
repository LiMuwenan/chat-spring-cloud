package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("topic-service")
public interface TopicServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/search/{tags}/{type}")
    @LoadBalanced
    long searchTopic(@PathVariable String tags, @PathVariable int type);
}
