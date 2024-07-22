package com.i7.eatit.domain.tag.dto;

public class MemberTechStackDTO {
    private int stackCode;
    private int memberId;

    MemberTechStackDTO() {}

    public MemberTechStackDTO(int stackCode, int memberId) {
        this.stackCode = stackCode;
        this.memberId = memberId;
    }

    public int getStackCode() {
        return stackCode;
    }

    public void setStackCode(int stackCode) {
        this.stackCode = stackCode;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberTechStackDTO{" +
                "stackCode=" + stackCode +
                ", memberId=" + memberId +
                '}';
    }
}
