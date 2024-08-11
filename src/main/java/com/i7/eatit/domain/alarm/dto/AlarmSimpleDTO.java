package com.i7.eatit.domain.alarm.dto;

import java.time.LocalDateTime;

public class AlarmSimpleDTO {

    private int alarmId;
    private int memberId;             //alarm.memberId
    private int meetingId;
    private String meetingName;     //meeting.title
    private LocalDateTime alarmTime;
    private boolean alarmChecked;

    public AlarmSimpleDTO() {
    }

    public AlarmSimpleDTO(int alarmId, int memberId, int meetingId, String meetingName, LocalDateTime alarmTime, boolean alarmChecked) {
        this.alarmId = alarmId;
        this.memberId = memberId;
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.alarmTime = alarmTime;
        this.alarmChecked = alarmChecked;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public LocalDateTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalDateTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean isAlarmChecked() {
        return alarmChecked;
    }

    public void setAlarmChecked(boolean alarmChecked) {
        this.alarmChecked = alarmChecked;
    }

    @Override
    public String toString() {
        return "AlarmSimpleDTO{" +
                "alarmId=" + alarmId +
                ", memberId=" + memberId +
                ", meetingId=" + meetingId +
                ", meetingName='" + meetingName + '\'' +
                ", alarmTime=" + alarmTime +
                ", alarmChecked=" + alarmChecked +
                '}';
    }
}
