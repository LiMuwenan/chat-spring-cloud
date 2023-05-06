package com.ligen.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("message-service")
public interface MessageServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/message/")
    String receivePub(@RequestParam long topic,
                      @RequestParam long fromUser,
                      @RequestParam String content,
                      @RequestParam String head,
                      @RequestParam int seqId);
}
