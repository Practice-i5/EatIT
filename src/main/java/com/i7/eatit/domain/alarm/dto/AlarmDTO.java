package com.i7.eatit.domain.alarm.dto;

import java.time.LocalDateTime;

public class AlarmDTO {

    private int alarmId;
    private String alarmDetail;
    private LocalDateTime alarmTime;
    private int memberId;
    private int participationId;
    private String alarmStatus;
    private boolean alarmChecked;
    private int meetingId;

    public AlarmDTO() {
    }

    public AlarmDTO(int alarmId, String alarmDetail, LocalDateTime alarmTime, int memberId, int participationId, String alarmStatus, boolean alarmChecked, int meetingId) {
        this.alarmId = alarmId;
        this.alarmDetail = alarmDetail;
        this.alarmTime = alarmTime;
        this.memberId = memberId;
        this.participationId = participationId;
        this.alarmStatus = alarmStatus;
        this.alarmChecked = alarmChecked;
        this.meetingId = meetingId;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
}
