package com.i7.eatit.domain.relationship.dto;

import com.i7.eatit.domain.user.dto.UserPhotoProfileDTO;

import java.sql.Date;

public class FollowInfoDetailDTO {
    private int followId;
    private int followerId;
    private int followeeId;
    private String followDate;
    private UserPhotoProfileDTO detailProfile;

    public FollowInfoDetailDTO() {
    }

    public FollowInfoDetailDTO(int followId, int followerId, int followeeId, String followDate, UserPhotoProfileDTO detailProfile) {
        this.followId = followId;
        this.followerId = followerId;
        this.followeeId = followeeId;
        this.followDate = followDate;
        this.detailProfile = detailProfile;
    }

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(int followeeId) {
        this.followeeId = followeeId;
    }

    public String getFollowDate() {
        return followDate;
    }

    public void setFollowDate(String followDate) {
        this.followDate = followDate;
    }

    public UserPhotoProfileDTO getDetailProfile() {
        return detailProfile;
    }

    public void setDetailProfile(UserPhotoProfileDTO detailProfile) {
        this.detailProfile = detailProfile;
    }

    @Override
    public String toString() {
        return "FollowInfoDetailDTO{" +
                "followId=" + followId +
                ", followerId=" + followerId +
                ", followeeId=" + followeeId +
                ", followDate='" + followDate + '\'' +
                ", detailProfile=" + detailProfile +
                '}';
    }
}
