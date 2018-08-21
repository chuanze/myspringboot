package com.chuanze.rabbitmq.direct;

import com.chuanze.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DirectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送信息
     * @param message
     */
    public void send(String message){
        String msg= JsonUtil.beanToString(message);
        log.info("DirectConfig send mesage:"+msg);
        amqpTemplate.convertAndSend(DirectConfig.QUEUE,msg);
    }
}
