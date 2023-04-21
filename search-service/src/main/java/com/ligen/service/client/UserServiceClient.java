package com.ligen.service.client;

import com.ligen.entity.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/search/{opts}/{type}")
    @LoadBalanced
    User searchUser(@PathVariable String opts, @PathVariable int type);

}
