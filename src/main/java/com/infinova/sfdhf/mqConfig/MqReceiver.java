package com.infinova.sfdhf.mqConfig;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "snap"),exchange = @Exchange(value = "attendanceExchange"),key = "hello"),})
    @RabbitHandler
    public  void process(String receiveMsg){
        System.out.println("receive:"+receiveMsg);
    }
}
