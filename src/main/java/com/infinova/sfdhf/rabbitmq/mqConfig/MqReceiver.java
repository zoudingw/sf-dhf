package com.infinova.sfdhf.rabbitmq.mqConfig;

import com.alibaba.fastjson.JSON;
import com.inf.fvs.cluster.protocol.base.ECmdType;
import com.infinova.sfdhf.rabbitmq.entity.CmdTpye;
import com.infinova.sfdhf.rabbitmq.entity.Command;
import com.infinova.sfdhf.service.impl.FaceSignCommondHandler;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {

    @Autowired
    FaceSignCommondHandler faceSignCommondHandler;

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "snap"),exchange = @Exchange(value = "attendanceExchange"),key = "hello")})
    //@RabbitListener(queues = "snap")
    @RabbitHandler
    public  void process(Message receiveMsg){
        try {
            String msg = new String(receiveMsg.getBody(),"UTF-8");
            Command command = JSON.parseObject(msg, Command.class);
            CmdTpye byDes = CmdTpye.getByDes(command.getCmdType());
            if(byDes.equals(CmdTpye.FaceSign)){
                faceSignCommondHandler.commondHandler(command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
