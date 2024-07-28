package com.i7.eatit.domain.review.dto;

import java.util.List;

public class ReviewDTO {
    private int meetingId;
    private String nickname;
    private List<String> feedback;

    // Getters and Setters
    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String membernickname) {
        this.nickname = membernickname;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }
}