package com.ligen.controller;

import com.ligen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/register/{scheme}/{userid}")
    @ResponseBody
    public String registerNewUser(@PathVariable String scheme, @PathVariable String userid) {
        LOGGER.info(scheme);
        LOGGER.info(userid);
        return "注册成功";
    }
}
