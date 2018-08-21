package com.chuanze.rabbitmq.fanout;

import com.chuanze.rabbitmq.topic.TopicConfig;
import com.chuanze.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FanoutSender {
    @Autowired
    AmqpTemplate amqpTemplate;
    //发送两个消息
    public void send(Object message){
        String msg= JsonUtil.beanToString(message);
        log.info("send fanout message:"+msg);
        amqpTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE,"",msg);
    }
}
