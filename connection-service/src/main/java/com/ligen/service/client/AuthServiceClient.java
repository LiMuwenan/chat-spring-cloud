package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * auth-service服务的接口定义
 */
@FeignClient("auth-service")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.GET, value =  "/receive/{msgClientAcc}/")
    @LoadBalanced
    public String receive(@PathVariable String msgClientAcc);
}
