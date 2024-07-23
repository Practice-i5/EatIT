package com.i7.eatit.domain.picture.dto;

public class MemberPhotoDTO {

    private int memberPhotoID;
    private int memberId;
    private String photoPath;
    private String photoName;


    public MemberPhotoDTO(){}

    public MemberPhotoDTO(int memberPhotoID, int memberId, String photoPath, String photoName) {
        this.memberPhotoID = memberPhotoID;
        this.memberId = memberId;
        this.photoPath = photoPath;
        this.photoName = photoName;
    }

    public int getMemberPhotoID() {
        return memberPhotoID;
    }

    public void setMemberPhotoID(int memberPhotoID) {
        this.memberPhotoID = memberPhotoID;
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
                "memberPhotoID=" + memberPhotoID +
                ", memberId=" + memberId +
                ", photoPath='" + photoPath + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
