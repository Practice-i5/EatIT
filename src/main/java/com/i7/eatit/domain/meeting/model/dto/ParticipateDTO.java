package com.i7.eatit.domain.meeting.model.dto;

public class ParticipateDTO {

    private int meetingId;
    private int memberId;
    private String role;

    public ParticipateDTO() {}

    public ParticipateDTO(int meetingId, int memberId, String role) {
        this.meetingId = meetingId;
        this.memberId = memberId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ParticipateDTO{" +
                "meetingId=" + meetingId +
                ", memberId=" + memberId +
                ", role='" + role + '\'' +
                '}';
    }
}
