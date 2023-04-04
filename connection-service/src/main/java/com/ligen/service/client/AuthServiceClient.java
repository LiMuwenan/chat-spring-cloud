package com.ligen.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * auth-service服务的接口定义
 */
@FeignClient("auth-service")
public interface AuthServiceClient {

    @RequestMapping("/register/{msgClientAcc}")
    public String registerNewUser(@PathVariable String msgClientAcc);
}
