package com.i7.eatit.domain.picture.dto;

public class MemberPhotoDTO {

    private int MemberPhotoID;
    private int memberId;
    private String photoURL;

    public MemberPhotoDTO(){}

    public MemberPhotoDTO(int memberPhotoID, int memberId, String photoURL) {
        MemberPhotoID = memberPhotoID;
        this.memberId = memberId;
        this.photoURL = photoURL;
    }

    public int getMemberPhotoID() {
        return MemberPhotoID;
    }

    public void setMemberPhotoID(int memberPhotoID) {
        MemberPhotoID = memberPhotoID;
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


}
