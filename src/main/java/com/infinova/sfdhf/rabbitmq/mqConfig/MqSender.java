package com.infinova.sfdhf.rabbitmq.mqConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class MqSender {

    @Autowired
    private AmqpTemplate template;

    public void send(){
        template.convertAndSend("attendanceExchange","hello","hello");
       // template.convertAndSend("snap","hello");
    }

    @PostConstruct
    public void tets() throws Exception{
        while(true){
            send();
            Thread.sleep(5000);
        }
    }
}
