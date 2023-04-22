package com.ligen.service.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * auth-service服务的接口定义
 */
@FeignClient("auth-service")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.GET, value =  "/receiveAcc/{msgClientAcc}/")
    @LoadBalanced
    String receiveAcc(@PathVariable String msgClientAcc);

    @RequestMapping(method = RequestMethod.GET, value =  "/receiveLogin/{msgClientLogin}/{sessionId}/{ip}")
    @LoadBalanced
    long receiveLogin(@PathVariable String msgClientLogin, @PathVariable String sessionId, @PathVariable String ip);
}
