package com.chuanze.rabbitmq.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
    public static final String QUEUE="queue";
    public Queue queue(){
        return new Queue(QUEUE,true);
    }
}
