package com.ligen.controller;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.User;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/register/{scheme}/{pub}/{tags}/{secret}")
    @ResponseBody
    String registerNewUser(@PathVariable String scheme, @PathVariable String pub, @PathVariable String tags, @PathVariable String secret) {
        LOGGER.info(scheme, pub, tags);
        User user = userService.createNewUser(scheme, JSONObject.parseObject(pub, HashMap.class), JSONObject.parseObject(tags, HashMap.class), secret);
        return user.toString();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login/{scheme}/{secret}/{credClient}/{sessionId}/{ip}")
    @ResponseBody
    boolean login(@PathVariable String scheme, @PathVariable String secret, @PathVariable String credClient,
                  @PathVariable String sessionId, @PathVariable String ip) {
        boolean isLogin = false;
        if ("basic".equals(scheme)) {
            MsgCredClient cred = JSONObject.parseObject(credClient, MsgCredClient.class);
            isLogin = userService.loginBasic(secret, scheme, cred, sessionId, ip);
            LOGGER.info("登录状态：" + isLogin);
        }
        return isLogin;
    }
}
