package com.chuanze.rabbitmq.header;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class HeaderConfig {
    public static final String HEADER_EXCHANGE="header.exchange";
    public static final String HEADER_QUEUE="header.queue";
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange(HEADER_EXCHANGE);
    }

    @Bean
    public Queue headerQueue(){
        return new Queue(HEADER_QUEUE);
    }
    @Bean
    public Binding headerBinding(){
        Map<String,Object> map=new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
        return BindingBuilder.bind(headerQueue()).to(headersExchange()).whereAll(map).match();
    }
}
