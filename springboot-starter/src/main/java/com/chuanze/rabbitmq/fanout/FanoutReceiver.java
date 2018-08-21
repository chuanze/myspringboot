package com.chuanze.rabbitmq.fanout;

import com.chuanze.rabbitmq.topic.TopicConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FanoutReceiver {
    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE1)
    public void receiveTopic1(String message){
        log.info("receive fanout queue1 message"+message);
    }

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE2)
    public void receiveTopic2(String message){
        log.info("receive fanout queue2 message"+message);
    }
}
