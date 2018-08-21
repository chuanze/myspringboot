package com.chuanze.rabbitmq.topic;

import com.chuanze.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TopicSender {
    @Autowired
    AmqpTemplate amqpTemplate;
    //发送两个消息
    public void send(Object message){
        String msg= JsonUtil.beanToString(message);
        log.info("send topic message:"+msg);
        amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE,"topic.key1",msg+" one");
        amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE,"topic.key2",msg+" two");
    }
}
