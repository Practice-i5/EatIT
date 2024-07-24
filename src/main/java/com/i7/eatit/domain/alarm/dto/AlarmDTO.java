package com.i7.eatit.domain.alarm.dto;

import java.time.LocalDateTime;

public class AlarmDTO {

    private int alarmId;
    private String alarmDetail;
    private LocalDateTime alarmTime;
    private int member_id;
    private int participationId;
    private String alarmStatus;
    private boolean alarmChecked;

    public AlarmDTO() {
    }

    public AlarmDTO(int alarmId, String alarmDetail, LocalDateTime alarmTime, int member_id, int participationId, String alarmStatus, boolean alarmChecked) {
        this.alarmId = alarmId;
        this.alarmDetail = alarmDetail;
        this.alarmTime = alarmTime;
        this.member_id = member_id;
        this.participationId = participationId;
        this.alarmStatus = alarmStatus;
        this.alarmChecked = alarmChecked;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmDetail() {
        return alarmDetail;
    }

    public void setAlarmDetail(String alarmDetail) {
        this.alarmDetail = alarmDetail;
    }

    public LocalDateTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalDateTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getParticipationId() {
        return participationId;
    }

    public void setParticipationId(int participationId) {
        this.participationId = participationId;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public boolean isAlarmChecked() {
        return alarmChecked;
    }

    public void setAlarmChecked(boolean alarmChecked) {
        this.alarmChecked = alarmChecked;
    }
}
