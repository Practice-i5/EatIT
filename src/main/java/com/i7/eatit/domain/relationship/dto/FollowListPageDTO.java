package com.i7.eatit.domain.relationship.dto;

public class FollowListPageDTO {

    private int followeeId;
    private String nickname;
    private String photoUrl;

    public FollowListPageDTO(int followeeId, String nickname, String photoUrl) {
        this.followeeId = followeeId;
        this.nickname = nickname;
        this.photoUrl = photoUrl;
    }

    public int getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(int followeeId) {
        this.followeeId = followeeId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "FollowListPageDTO{" +
                "followeeId=" + followeeId +
                ", nickname='" + nickname + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
