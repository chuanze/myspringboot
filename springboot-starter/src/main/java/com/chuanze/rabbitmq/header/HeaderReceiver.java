package com.chuanze.rabbitmq.header;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class HeaderReceiver {
    @RabbitListener(queues = HeaderConfig.HEADER_QUEUE)
    public void receiveHeader(byte[] message){
        log.info("header receiver message:"+new String(message));
    }

}
