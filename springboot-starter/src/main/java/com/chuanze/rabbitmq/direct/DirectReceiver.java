package com.chuanze.rabbitmq.direct;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DirectReceiver {
    @RabbitListener(queues = DirectConfig.QUEUE)
    public void receive(String message){
        log.info("Direct receive message"+message);
    }
}
