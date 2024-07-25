package com.i7.eatit.domain.meeting.model.dto;

import java.sql.Timestamp;

public class PreviewMeetingDTO {

    private int meetingId;
    private String title;
    private String locationName;
    private String meetingImageURL;
    private String hostImageURL;
    private String status;
    private Timestamp scheduledDate;
    private int recruitMemberNumber;
    private int recruitmentNumber;

    public PreviewMeetingDTO() {}

    public PreviewMeetingDTO(int meetingId, String title, String locationName, String meetingImageURL, String hostImageURL, String status, Timestamp scheduledDate, int recruitMemberNumber, int recruitmentNumber) {
        this.meetingId = meetingId;
        this.title = title;
        this.locationName = locationName;
        this.meetingImageURL = meetingImageURL;
        this.hostImageURL = hostImageURL;
        this.status = status;
        this.scheduledDate = scheduledDate;
        this.recruitMemberNumber = recruitMemberNumber;
        this.recruitmentNumber = recruitmentNumber;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getMeetingImageURL() {
        return meetingImageURL;
    }

    public void setMeetingImageURL(String meetingImageURL) {
        this.meetingImageURL = meetingImageURL;
    }

    public String getHostImageURL() {
        return hostImageURL;
    }

    public void setHostImageURL(String hostImageURL) {
        this.hostImageURL = hostImageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Timestamp scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public int getRecruitMemberNumber() {
        return recruitMemberNumber;
    }

    public void setRecruitMemberNumber(int recruitMemberNumber) {
        this.recruitMemberNumber = recruitMemberNumber;
    }

    public int getRecruitmentNumber() {
        return recruitmentNumber;
    }

    public void setRecruitmentNumber(int recruitmentNumber) {
        this.recruitmentNumber = recruitmentNumber;
    }

    @Override
    public String toString() {
        return "PreviewMeetingDTO{" +
                "meetingId=" + meetingId +
                ", title='" + title + '\'' +
                ", locationName='" + locationName + '\'' +
                ", meetingImageURL='" + meetingImageURL + '\'' +
                ", hostImageURL='" + hostImageURL + '\'' +
                ", status='" + status + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", recruitMemberNumber=" + recruitMemberNumber +
                ", recruitmentNumber=" + recruitmentNumber +
                '}';
    }
}
