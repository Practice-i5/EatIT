package com.i7.eatit.domain.meeting.model.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class DetailMeetingDTO {

    private int meetingId;
    private int reportedMemberId;
    private int decMemberId;
    private int decHuman;
    private int decMeeting;
    private int participateFree;
    private int participateAcc;
    private String introduction;

    public DetailMeetingDTO() {}

    public DetailMeetingDTO(int meetingId, int reportedMemberId, int decMemberId, int decHuman, int decMeeting, int participateFree, int participateAcc, String introduction) {
        this.meetingId = meetingId;
        this.reportedMemberId = reportedMemberId;
        this.decMemberId = decMemberId;
        this.decHuman = decHuman;
        this.decMeeting = decMeeting;
        this.participateFree = participateFree;
        this.participateAcc = participateAcc;
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

    public int getDecHuman() {
        return decHuman;
    }

    public void setDecHuman(int decHuman) {
        this.decHuman = decHuman;
    }

    public int getDecMeeting() {
        return decMeeting;
    }

    public void setDecMeeting(int decMeeting) {
        this.decMeeting = decMeeting;
    }

    public int getParticipateFree() {
        return participateFree;
    }

    public void setParticipateFree(int participateFree) {
        this.participateFree = participateFree;
    }

    public int getParticipateAcc() {
        return participateAcc;
    }

    public void setParticipateAcc(int participateAcc) {
        this.participateAcc = participateAcc;
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
                ", decHuman=" + decHuman +
                ", decMeeting=" + decMeeting +
                ", participateFree=" + participateFree +
                ", participateAcc=" + participateAcc +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
