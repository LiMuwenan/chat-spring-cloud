package com.ligen.controller;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.User;
import com.ligen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
