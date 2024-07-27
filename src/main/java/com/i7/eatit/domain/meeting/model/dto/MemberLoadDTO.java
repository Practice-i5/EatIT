package com.i7.eatit.domain.meeting.model.dto;

public class MemberLoadDTO {

    private int meetingId;
    private int memberId;
    private String nickname;
    private String memberImageURL;
    private String role;

    public MemberLoadDTO() {}

    public MemberLoadDTO(int meetingId, int memberId, String nickname, String memberImageURL) {
        this.meetingId = meetingId;
        this.memberId = memberId;
        this.nickname = nickname;
        this.memberImageURL = memberImageURL;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMemberImageURL() {
        return memberImageURL;
    }

    public void setMemberImageURL(String memberImageURL) {
        this.memberImageURL = memberImageURL;
    }


    @Override
    public String toString() {
        return "memberLoadDTO{" +
                "meetingId=" + meetingId +
                ", memberId=" + memberId +
                ", nickname='" + nickname + '\'' +
                ", memberImageURL='" + memberImageURL + '\'' +
                '}';
    }
}
