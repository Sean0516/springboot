package com.voicecyber.model;

import java.util.Date;

public class Alarm {
    private String id;

    private Integer voiceid;

    private String voiceip;

    private String alarmType;

    private Date startAlarmTime;

    private Date stopAlarmTime;

    private String alarmMsg;

    private Integer alarmLevel;

    private String alarmMethod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getVoiceid() {
        return voiceid;
    }

    public void setVoiceid(Integer voiceid) {
        this.voiceid = voiceid;
    }

    public String getVoiceip() {
        return voiceip;
    }

    public void setVoiceip(String voiceip) {
        this.voiceip = voiceip == null ? null : voiceip.trim();
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType == null ? null : alarmType.trim();
    }

    public Date getStartAlarmTime() {
        return startAlarmTime;
    }

    public void setStartAlarmTime(Date startAlarmTime) {
        this.startAlarmTime = startAlarmTime;
    }

    public Date getStopAlarmTime() {
        return stopAlarmTime;
    }

    public void setStopAlarmTime(Date stopAlarmTime) {
        this.stopAlarmTime = stopAlarmTime;
    }

    public String getAlarmMsg() {
        return alarmMsg;
    }

    public void setAlarmMsg(String alarmMsg) {
        this.alarmMsg = alarmMsg == null ? null : alarmMsg.trim();
    }

    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmMethod() {
        return alarmMethod;
    }

    public void setAlarmMethod(String alarmMethod) {
        this.alarmMethod = alarmMethod == null ? null : alarmMethod.trim();
    }
}