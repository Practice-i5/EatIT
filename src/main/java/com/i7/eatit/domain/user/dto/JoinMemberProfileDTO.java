package com.i7.eatit.domain.user.dto;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import java.util.List;

public class JoinMemberProfileDTO {
    private int meeting_id; // 미팅 ID 추가
    private int member_id; // 유저 id
    private String nickname; // 닉네임
    private MemberPhotoDTO memberPhoto; // 유저 대표 사진
    private List<TechStackDTO> myTechStackList; // 유저의 보유 기술스택

    // 기본 생성자
    public JoinMemberProfileDTO() {}

    // 모든 필드를 사용하는 생성자
    public JoinMemberProfileDTO(int meeting_id, int member_id, String nickname, List<TechStackDTO> myTechStackList, MemberPhotoDTO memberPhoto) {
        this.meeting_id = meeting_id;
        this.member_id = member_id;
        this.nickname = nickname;
        this.myTechStackList = myTechStackList;
        this.memberPhoto = memberPhoto;
    }

    // Getter와 Setter 메소드
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

    public List<TechStackDTO> getMyTechStackList() {
        return myTechStackList;
    }

    public void setMyTechStackList(List<TechStackDTO> myTechStackList) {
        this.myTechStackList = myTechStackList;
    }

    public MemberPhotoDTO getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(MemberPhotoDTO memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    @Override
    public String toString() {
        return "JoinMemberProfileDTO{" +
                "meeting_id=" + meeting_id +
                ", member_id=" + member_id +
                ", nickname='" + nickname + '\'' +
                ", myTechStackList=" + myTechStackList +
                ", memberPhoto=" + memberPhoto +
                '}';
    }
}