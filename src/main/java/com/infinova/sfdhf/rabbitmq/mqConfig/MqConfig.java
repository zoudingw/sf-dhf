package com.infinova.sfdhf.rabbitmq.mqConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    public Queue attendanceQueue(){
        return new Queue("snap");
    }

    @Bean

    public TopicExchange attendanceExchange(){
        return new TopicExchange("attendanceExchange");
    }

    @Bean
    Binding binding(Queue attendanceQueue,TopicExchange attendanceExchange){
        return BindingBuilder.bind(attendanceQueue).to(attendanceExchange).with("hello");
    }

}
