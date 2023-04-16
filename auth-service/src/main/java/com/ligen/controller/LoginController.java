package com.ligen.controller;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.message.client.MsgClientAcc;
import com.ligen.entity.message.client.MsgClientLogin;
import com.ligen.entity.message.sub.MsgCredClient;
import com.ligen.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 注册、登录认证、重置密码
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value =  "/receiveAcc/{msgClientAcc}/")
    @ResponseBody
    public String receiveAcc(@PathVariable String msgClientAcc) {
        MsgClientAcc acc = JSONObject.parseObject(msgClientAcc, MsgClientAcc.class);
        LOGGER.info(msgClientAcc);
        if ("reset".equals(acc.getScheme())) {
            // 重置密码
        }
        return loginService.register(acc.getScheme(), acc.getDesc().getPub(), acc.getTags(), acc.getSecret()).toString();

    }

    @RequestMapping(method = RequestMethod.GET, value =  "/receiveLogin/{msgClientLogin}/{sessionId}/{ip}")
    @ResponseBody
    public String receiveLogin(@PathVariable String msgClientLogin, @PathVariable String sessionId, @PathVariable String ip) {
        MsgClientLogin login = JSONObject.parseObject(msgClientLogin, MsgClientLogin.class);
        LOGGER.info(msgClientLogin);
        LOGGER.info(login.getScheme());
        LOGGER.info(login.getSecret());
        List<MsgCredClient> cred = login.getCred();
        MsgCredClient msgCredClient = cred.get(0);
        boolean isLogin = loginService.login(login.getScheme(), login.getSecret(), msgCredClient.toString(), sessionId, ip);

        if (isLogin) {
            return "登录成功";
        } else {
            return "登录失败";
        }

    }
}
