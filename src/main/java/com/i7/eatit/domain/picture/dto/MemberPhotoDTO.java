package com.i7.eatit.domain.picture.dto;

public class MemberPhotoDTO {

    private int memberPhotoID;
    private int memberId;
    private String photoURL;

    public MemberPhotoDTO(){}

    public MemberPhotoDTO(int memberPhotoID, int memberId, String photoURL) {
        this.memberPhotoID = memberPhotoID;
        this.memberId = memberId;
        this.photoURL = photoURL;
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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "MemberPhotoDTO{" +
                "memberPhotoID=" + memberPhotoID +
                ", memberId=" + memberId +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
