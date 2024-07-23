package com.i7.eatit.domain.picture.dto;

public class MeetingPhotoDTO {

    private int meetingPhotoID;
    private int meetingId;
    private String photoPath;
    private String photoName;

    public MeetingPhotoDTO() {}

    public MeetingPhotoDTO(int meetingPhotoID, int meetingId, String photoPath, String photoName) {
        this.meetingPhotoID = meetingPhotoID;
        this.meetingId = meetingId;
        this.photoPath = photoPath;
        this.photoName = photoName;
    }

    public int getMeetingPhotoID() {
        return meetingPhotoID;
    }

    public void setMeetingPhotoID(int meetingPhotoID) {
        this.meetingPhotoID = meetingPhotoID;
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
                "meetingPhotoID=" + meetingPhotoID +
                ", meetingId=" + meetingId +
                ", photoPath='" + photoPath + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
