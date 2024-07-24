package com.i7.eatit.domain.picture.dto;

public class MemberPhotoDTO {

    private int memberPhotoId;
    private int memberId;
    private String photoPath;
    private String photoName;


    public MemberPhotoDTO(){}

    public MemberPhotoDTO(int memberPhotoId, int memberId, String photoPath, String photoName) {
        this.memberPhotoId = memberPhotoId;
        this.memberId = memberId;
        this.photoPath = photoPath;
        this.photoName = photoName;
    }

    public int getMemberPhotoId() {
        return memberPhotoId;
    }

    public void setMemberPhotoId(int memberPhotoId) {
        this.memberPhotoId = memberPhotoId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
        return "MemberPhotoDTO{" +
                "memberPhotoId=" + memberPhotoId +
                ", memberId=" + memberId +
                ", photoPath='" + photoPath + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
