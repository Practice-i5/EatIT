package com.i7.eatit.domain.alarm.dto;

public class AlarmUpdateDTO {
    private int alarmId;
    private String alarmStatus;
    private boolean alarmChecked;

    // 참여 테이블   //tbl_meeting_participation
    private String role;        //role
    private int meetingId;      //meeting_id
    private int memberId;       //member_id
    // 참여 테이블 End

    private int memberNum;      //tbl_meeting.recruit_member_number

    public AlarmUpdateDTO() {
    }

    public AlarmUpdateDTO(int alarmId, String alarmStatus, boolean alarmChecked, String role, int meetingId, int memberId, int memberNum) {
        this.alarmId = alarmId;
        this.alarmStatus = alarmStatus;
        this.alarmChecked = alarmChecked;
        this.role = role;
        this.meetingId = meetingId;
        this.memberId = memberId;
        this.memberNum = memberNum;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }
}
