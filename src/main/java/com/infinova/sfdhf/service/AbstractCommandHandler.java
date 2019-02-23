package com.infinova.sfdhf.service;

import com.infinova.sfdhf.rabbitmq.entity.Command;

public abstract class AbstractCommandHandler {
    String cmdType;

    public abstract  void commondHandler(Command data);

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }
}
