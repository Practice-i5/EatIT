package com.i7.eatit.domain.alarm.dto;

import java.time.LocalDateTime;

public class AlarmSimpleDTO {

    private int alarmId;
    private int hostId;             //participation.memberId
    private int meetingId;
    private int receivingMemberId;     //alarm.memberId
    private LocalDateTime time;

    public AlarmSimpleDTO() {
    }

    public AlarmSimpleDTO(int alarmId, int hostId, int meetingId, int receivingMemberId, LocalDateTime time) {
        this.alarmId = alarmId;
        this.hostId = hostId;
        this.meetingId = meetingId;
        this.receivingMemberId = receivingMemberId;
        this.time = time;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getReceivingMemberId() {
        return receivingMemberId;
    }

    public void setReceivingMemberId(int receivingMemberId) {
        this.receivingMemberId = receivingMemberId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
