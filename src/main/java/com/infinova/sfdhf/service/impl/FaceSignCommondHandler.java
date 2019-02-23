package com.infinova.sfdhf.service.impl;

import com.alibaba.fastjson.JSON;
import com.infinova.sfdhf.face.entity.PersonMatchVO;
import com.infinova.sfdhf.rabbitmq.entity.Command;
import com.infinova.sfdhf.service.AbstractCommandHandler;
import org.springframework.stereotype.Component;

@Component
public class FaceSignCommondHandler extends AbstractCommandHandler {
    @Override
    public void commondHandler(Command data) {
        super.setCmdType(data.getCmdType());
        PersonMatchVO personMatchVO = JSON.parseObject(data.getData(), PersonMatchVO.class);

    }
}
