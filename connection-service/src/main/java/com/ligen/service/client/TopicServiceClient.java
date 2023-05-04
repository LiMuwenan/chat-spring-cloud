package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("topic-service")
public interface TopicServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/sub/")
    @LoadBalanced
    String subNewTopic(@RequestParam("userFrom") long userFrom, @RequestParam("userTo") long userTo, @RequestParam("topic") String topic);
}
