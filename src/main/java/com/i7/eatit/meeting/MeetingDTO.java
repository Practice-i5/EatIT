package com.i7.eatit.meeting;

import java.sql.Date;

public class MeetingDTO {

    private String meetingName;
    private String meetingDescription;
    private String meetingImageURL;
    private int admit;
    private int participants;
    private Date meetingDate;
    private String leaderImageURL;
    private Boolean isLiked;
    private String shareURL;
    private String category;
    private String process;

    public MeetingDTO() {}

    public MeetingDTO(String meetingName, String meetingDescription, String meetingImageURL, int admit, int participants, Date meetingDate, String leaderImageURL, Boolean isLiked, String shareURL, String category, String process) {
        this.meetingName = meetingName;
        this.meetingDescription = meetingDescription;
        this.meetingImageURL = meetingImageURL;
        this.admit = admit;
        this.participants = participants;
        this.meetingDate = meetingDate;
        this.leaderImageURL = leaderImageURL;
        this.isLiked = isLiked;
        this.shareURL = shareURL;
        this.category = category;
        this.process = process;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getMeetingDescription() {
        return meetingDescription;
    }

    public void setMeetingDescription(String meetingDescription) {
        this.meetingDescription = meetingDescription;
    }

    public String getMeetingImageURL() {
        return meetingImageURL;
    }

    public void setMeetingImageURL(String meetingImageURL) {
        this.meetingImageURL = meetingImageURL;
    }

    public int getAdmit() {
        return admit;
    }

    public void setAdmit(int admit) {
        this.admit = admit;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getLeaderImageURL() {
        return leaderImageURL;
    }

    public void setLeaderImageURL(String leaderImageURL) {
        this.leaderImageURL = leaderImageURL;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "MeetingDTO{" +
                "meetingName='" + meetingName + '\'' +
                ", meetingDescription='" + meetingDescription + '\'' +
                ", meetingImageURL='" + meetingImageURL + '\'' +
                ", admit=" + admit +
                ", participants=" + participants +
                ", meetingDate=" + meetingDate +
                ", leaderImageURL='" + leaderImageURL + '\'' +
                ", isLiked=" + isLiked +
                ", shareURL='" + shareURL + '\'' +
                ", category='" + category + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}
