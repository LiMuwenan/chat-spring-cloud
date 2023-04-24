package com.ligen.config;

import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.impl.*;
import com.ligen.util.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 客户端消息策略注入
 */
@Configuration
public class MsgStrategyConfig {

    @Resource(name = "AccStrategy")
    private MsgHandleStrategy acc;
    @Resource(name = "GetStrategy")
    private MsgHandleStrategy get;
    @Resource(name = "HiStrategy")
    private MsgHandleStrategy hi;
    @Resource(name = "LeaveStrategy")
    private MsgHandleStrategy leave;
    @Resource(name = "LoginStrategy")
    private MsgHandleStrategy login;
    @Resource(name = "NoteStrategy")
    private MsgHandleStrategy note;
    @Resource(name = "PubStrategy")
    private MsgHandleStrategy pub;
    @Resource(name = "SetStrategy")
    private MsgHandleStrategy set;
    @Resource(name = "SubStrategy")
    private MsgHandleStrategy sub;

    @Bean
    public HashMap<String, MsgHandleStrategy> init() {
        HashMap<String, MsgHandleStrategy> map = new HashMap<>();
        map.put(CommonConstant.MSG_STRATEGY_ACC, acc);
        map.put(CommonConstant.MSG_STRATEGY_GET, get);
        map.put(CommonConstant.MSG_STRATEGY_HI, hi);
        map.put(CommonConstant.MSG_STRATEGY_LEAVE, leave);
        map.put(CommonConstant.MSG_STRATEGY_LOGIN, login);
        map.put(CommonConstant.MSG_STRATEGY_NOTE, note);
        map.put(CommonConstant.MSG_STRATEGY_PUB, pub);
        map.put(CommonConstant.MSG_STRATEGY_SET, set);
        map.put(CommonConstant.MSG_STRATEGY_SUB, sub);

        return map;
    }
}
