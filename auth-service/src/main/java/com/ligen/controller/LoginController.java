package com.ligen.controller;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.client.MsgClientAcc;
import com.ligen.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 注册、登录认证、重置密码
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value =  "/receive/{msgClientAcc}/")
    @ResponseBody
    public String receive(@PathVariable String msgClientAcc) {
        MsgClientAcc acc = JSONObject.parseObject(msgClientAcc, MsgClientAcc.class);
        LOGGER.info(msgClientAcc);
        // 登录
        if (acc.isLogin()) {
            return "forward:/login/" + acc.getScheme();
        }
        return loginService.register(acc.getScheme(), acc.getDesc().getPub(), acc.getTags(), acc.getSecret()).toString();
    }
}
