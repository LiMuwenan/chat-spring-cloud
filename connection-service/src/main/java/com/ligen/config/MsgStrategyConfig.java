package com.ligen.config;

import com.ligen.service.MsgHandleStrategy;
import com.ligen.service.impl.*;
import com.ligen.util.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class MsgStrategyConfig {

    @Bean
    public HashMap<String, MsgHandleStrategy> init() {
        HashMap<String, MsgHandleStrategy> map = new HashMap<>();
        map.put(CommonConstant.MSG_STRATEGY_HI, new MsgHiStrategy());
        map.put(CommonConstant.MSG_STRATEGY_GET, new MsgGetStrategy());
        map.put(CommonConstant.MSG_STRATEGY_SET, new MsgSetStrategy());
        map.put(CommonConstant.MSG_STRATEGY_NOTE, new MsgNoteStrategy());
        map.put(CommonConstant.MSG_STRATEGY_LOGIN, new MsgLoginStrategy());
        map.put(CommonConstant.MSG_STRATEGY_ACC, new MsgAccStrategy());
        map.put(CommonConstant.MSG_STRATEGY_LEAVE, new MsgLeaveStrategy());
        map.put(CommonConstant.MSG_STRATEGY_PUB, new MsgPubStrategy());
        map.put(CommonConstant.MSG_STRATEGY_SUB, new MsgSubStrategy());

        return map;
    }
}
