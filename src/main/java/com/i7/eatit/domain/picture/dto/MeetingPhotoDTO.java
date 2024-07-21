package com.i7.eatit.domain.picture.dto;

public class MeetingPhotoDTO {

    private int meetingPhotoID;
    private int meetingId;
    private String photoURL;

    public MeetingPhotoDTO() {}

    public MeetingPhotoDTO(int meetingPhotoID, int meetingId, String photoURL) {
        this.meetingPhotoID = meetingPhotoID;
        this.meetingId = meetingId;
        this.photoURL = photoURL;
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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }


}
