package com.chuanze.rabbitmq.topic;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TopicReceiver {
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message){
        log.info("receive topic queue1 message"+message);
    }

    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message){
        log.info("receive topic queue2 message"+message);
    }
}
