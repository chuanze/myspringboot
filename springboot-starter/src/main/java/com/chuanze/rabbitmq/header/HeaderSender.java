package com.chuanze.rabbitmq.header;

import com.chuanze.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class HeaderSender {
    @Autowired
    AmqpTemplate amqpTemplate;
    public void sendHeader(Object message){
        String msg=JsonUtil.beanToString(message);
        log.info("send header message:"+msg);
        Map<String,Object> map=new HashMap<>();
        MessageProperties properties=new MessageProperties();
        properties.setHeader("header1","value1");
        properties.setHeader("header2","value2");
        Message obj=new Message(msg.getBytes(),properties);
        amqpTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE,"",obj);
    }
}
