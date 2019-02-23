package com.infinova.sfdhf.face.entity;

public class AttendanceDeploy {
    private String deployId;
    private byte deployStatus;
    private String startTime;
    private String endTime;

    public String getDeployId() {
        return deployId;
    }

    public void setDeployId(String deployId) {
        this.deployId = deployId;
    }

    public byte getDeployStatus() {
        return deployStatus;
    }

    public void setDeployStatus(byte deployStatus) {
        this.deployStatus = deployStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
