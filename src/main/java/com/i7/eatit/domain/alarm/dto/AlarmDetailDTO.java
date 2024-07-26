package com.i7.eatit.domain.alarm.dto;

public class AlarmDetailDTO {

    int alarmId;
    private String alarmDetail;
    private int memberId;
    private String memberName;
    private int meetingId;
    private String meetingName;
    private String alarmStatus;

    public AlarmDetailDTO() {
    }

    public AlarmDetailDTO(int alarmId, String alarmDetail, int memberId, String memberName, int meetingId, String meetingName, String alarmStatus) {
        this.alarmId = alarmId;
        this.alarmDetail = alarmDetail;
        this.memberId = memberId;
        this.memberName = memberName;
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.alarmStatus = alarmStatus;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    @Override
    public String toString() {
        return "AlarmDetailDTO{" +
                "alarmId=" + alarmId +
                ", alarmDetail='" + alarmDetail + '\'' +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", meetingId=" + meetingId +
                ", meetingName='" + meetingName + '\'' +
                ", alarmStatus='" + alarmStatus + '\'' +
                '}';
    }
}
