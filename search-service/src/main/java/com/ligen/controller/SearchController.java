package com.ligen.controller;

import com.alibaba.fastjson.JSONObject;
import com.ligen.entity.Topic;
import com.ligen.entity.User;
import com.ligen.entity.message.client.MsgClientGet;
import com.ligen.entity.message.sub.MsgGetOpts;
import com.ligen.service.SearchService;
import com.ligen.util.CommonConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SearchController {

    @Resource
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.GET, path = "/receiveGet/{msgClientGet}")
    @ResponseBody
    public String receiveGet(@PathVariable String msgClientGet) {
        MsgClientGet clientGet = JSONObject.parseObject(msgClientGet, MsgClientGet.class);

        MsgGetOpts tags = clientGet.getTags();
        if (CommonConstant.WHAT_TAGS.equals(clientGet.getWhat())) {
            User user = null;
            // 查用户
            // 标签查
            if (tags.getMeth() != null) {
                user = searchService.searchUserByTag(tags.getMeth(), tags.getVal());
                return user.toString();
            }
            // 开放id查
            if (tags.getUser() != null ) {
                user = searchService.searchUserById(tags.getUser());
                return user.toString();
            }
            // 查会话
            Topic topic = null;
            if (tags.getTopic() != null) {
                // 标签查
                if (tags.getVal() != null) {
                    topic = searchService.searchTopicByTag(tags.getVal());
                } else {
                    topic = searchService.searchTopicById(tags.getTopic());
                }
                return topic.toString();
            }

        }


        return "";
    }
}
