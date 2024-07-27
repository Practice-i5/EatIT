package com.i7.eatit.domain.picture.dto;

public class MeetingPhotoDTO {

    private int meetingPhotoId;
    private int meetingId;
    private String photoPath;
    private String photoName;

    public MeetingPhotoDTO() {}

    public MeetingPhotoDTO(int meetingPhotoId, int meetingId, String photoPath, String photoName) {
        this.meetingPhotoId = meetingPhotoId;
        this.meetingId = meetingId;
        this.photoPath = photoPath;
        this.photoName = photoName;
    }

    public int getMeetingPhotoId() {
        return meetingPhotoId;
    }

    public void setMeetingPhotoId(int meetingPhotoId) {
        this.meetingPhotoId = meetingPhotoId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "MeetingPhotoDTO{" +
                "meetingPhotoId=" + meetingPhotoId +
                ", meetingId=" + meetingId +
                ", photoPath='" + photoPath + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
