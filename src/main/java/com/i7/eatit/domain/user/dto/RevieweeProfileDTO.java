package com.i7.eatit.domain.user.dto;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;

import java.util.List;

public class RevieweeProfileDTO {

    private int meeting_id;                     // 미팅 ID 추가
    private int member_id;                      // 유저 id
    private String nickname;                    // 닉네임
    private String photoPath;                   // 유저 대표 사진

    public RevieweeProfileDTO() {
    }

    public RevieweeProfileDTO(int meeting_id, int member_id, String nickname, String photoPath) {
        this.meeting_id = meeting_id;
        this.member_id = member_id;
        this.nickname = nickname;
        this.photoPath = photoPath;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // Getter
    public String getPhotoPath() {
        return photoPath;
    }

    // Setter
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "RevieweeProfileDTO{" +
                "meeting_id=" + meeting_id +
                ", member_id=" + member_id +
                ", nickname='" + nickname + '\'' +
                ", photoPath=" + photoPath +
                '}';
    }
}
