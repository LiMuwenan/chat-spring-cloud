package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("search-service")
public interface SearchServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/receiveGet/{msgClientGet}")
    @LoadBalanced
    String receiveGet(@PathVariable String msgClientGet);
}
