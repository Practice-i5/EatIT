package com.i7.eatit.domain.user.dto;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;

public class UserPhotoProfileDTO {
    private int memberId;

    private String nickname;
    private String phoneNumber;
    private String gender;

    private String withdrawalStatus = "N";
    private int reportedCount;

    MemberPhotoDTO memberPhoto;

    public UserPhotoProfileDTO() {}

    public UserPhotoProfileDTO(int memberId, String nickname, String phoneNumber, String gender, String withdrawalStatus, int reportedCount, MemberPhotoDTO memberPhoto) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.withdrawalStatus = withdrawalStatus;
        this.reportedCount = reportedCount;
        this.memberPhoto = memberPhoto;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public int getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(int reportedCount) {
        this.reportedCount = reportedCount;
    }

    public MemberPhotoDTO getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(MemberPhotoDTO memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    @Override
    public String toString() {
        return "UserPhotoProfileDTO{" +
                "memberId=" + memberId +
                ", nickname='" + nickname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", reportedCount=" + reportedCount +
                ", memberPhoto=" + memberPhoto +
                '}';
    }
}
