package com.infinova.sfdhf.rabbitmq.entity;

import com.inf.fvs.common.util.Strings;

public enum CmdTpye {

    FaceSign("faceSign");//人脸签到

    CmdTpye(String description) {
        this.description = description;
    }

    private String description;

    public static CmdTpye getByDes(String description) {
        if (!Strings.isNullOrEmpty(description)) {
            for (CmdTpye cpCmdType : CmdTpye.values()) {
                if (description.equals(cpCmdType.getDescription())) {
                    return cpCmdType;
                }
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
