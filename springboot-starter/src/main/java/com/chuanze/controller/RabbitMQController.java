package com.chuanze.controller;

import com.chuanze.rabbitmq.direct.DirectSender;
import com.chuanze.rabbitmq.fanout.FanoutSender;
import com.chuanze.rabbitmq.header.HeaderSender;
import com.chuanze.rabbitmq.topic.TopicSender;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitmq")
@Log4j2
public class RabbitMQController {
    @Autowired
    DirectSender directSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;

    @Autowired
    HeaderSender headerSender;
    @RequestMapping("direct")
    public String directType(@RequestParam(value = "message",required = false,defaultValue = "") String message){
        log.info("Controller get the param:"+message);
        if(StringUtils.isEmpty(message))
            message="This is DirectType";
        directSender.send(message);
        return "Success";
    }

    @RequestMapping("topic")
    public String topicType(@RequestParam(value = "message",required = false,defaultValue = "") String message){
        log.info("Controller get the param:"+message);
        if(StringUtils.isEmpty(message))
            message="This is TopicType";
        topicSender.send(message);
        return "Success";
    }

    @RequestMapping("fanout")
    public String fanoutType(@RequestParam(value = "message",required = false,defaultValue = "") String message){
        log.info("Controller get the param:"+message);
        if(StringUtils.isEmpty(message))
            message="This is FanoutType";
        fanoutSender.send(message);
        return "Success";
    }

    @RequestMapping("header")
    public String headerType(@RequestParam(value = "message",required = false,defaultValue = "") String message){
        log.info("Controller get the param:"+message);
        if(StringUtils.isEmpty(message))
            message="This is headerType";
        headerSender.sendHeader(message);
        return "Success";
    }
}