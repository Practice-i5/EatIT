package com.i7.eatit.domain.meeting.model.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class DetailMeetingDTO {

    private int meetingId;
    private int reportedMemberId;
    private int decMemberId;
    private boolean isDecHuman;
    private boolean isDecMeeting;
    private boolean isParticipateFree;
    private boolean isParticipateAcc;
    private String introduction;

    public DetailMeetingDTO() {}

    public DetailMeetingDTO(int meetingId, int reportedMemberId, int decMemberId, boolean isDecHuman, boolean isDecMeeting, boolean isParticipateFree, boolean isParticipateAcc, String introduction) {
        this.meetingId = meetingId;
        this.reportedMemberId = reportedMemberId;
        this.decMemberId = decMemberId;
        this.isDecHuman = isDecHuman;
        this.isDecMeeting = isDecMeeting;
        this.isParticipateFree = isParticipateFree;
        this.isParticipateAcc = isParticipateAcc;
        this.introduction = introduction;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getReportedMemberId() {
        return reportedMemberId;
    }

    public void setReportedMemberId(int reportedMemberId) {
        this.reportedMemberId = reportedMemberId;
    }

    public int getDecMemberId() {
        return decMemberId;
    }

    public void setDecMemberId(int decMemberId) {
        this.decMemberId = decMemberId;
    }

    public boolean isDecHuman() {
        return isDecHuman;
    }

    public void setDecHuman(boolean decHuman) {
        isDecHuman = decHuman;
    }

    public boolean isDecMeeting() {
        return isDecMeeting;
    }

    public void setDecMeeting(boolean decMeeting) {
        isDecMeeting = decMeeting;
    }

    public boolean isParticipateFree() {
        return isParticipateFree;
    }

    public void setParticipateFree(boolean participateFree) {
        isParticipateFree = participateFree;
    }

    public boolean isParticipateAcc() {
        return isParticipateAcc;
    }

    public void setParticipateAcc(boolean participateAcc) {
        isParticipateAcc = participateAcc;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "DetailMeetingDTO{" +
                "meetingId=" + meetingId +
                ", reportedMemberId=" + reportedMemberId +
                ", decMemberId=" + decMemberId +
                ", isDecHuman=" + isDecHuman +
                ", isDecMeeting=" + isDecMeeting +
                ", isParticipateFree=" + isParticipateFree +
                ", isParticipateAcc=" + isParticipateAcc +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
