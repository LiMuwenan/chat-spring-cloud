package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/register/{scheme}/{pub}/{tags}/{secret}")
    @LoadBalanced
    String registerNewUser(@PathVariable String scheme, @PathVariable String pub, @PathVariable String tags, @PathVariable String secret);

    @RequestMapping(method = RequestMethod.GET, path = "/login/{scheme}/{secret}/{credClient}")
    @LoadBalanced
    boolean login(@PathVariable String scheme, @PathVariable String secret, @PathVariable String credClient);

}
