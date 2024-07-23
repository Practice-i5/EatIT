package com.i7.eatit.domain.tag.dto;

public class MemberTechStackDetailDTO {

    private int stackCode;
    private int memberId;
    private TechStackTypeDTO techStack;

    public MemberTechStackDetailDTO(){}

    public MemberTechStackDetailDTO(int stackCode, int memberId, TechStackTypeDTO techStack) {
        this.stackCode = stackCode;
        this.memberId = memberId;
        this.techStack = techStack;
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

    public TechStackTypeDTO getTechStack() {
        return techStack;
    }

    public void setTechStack(TechStackTypeDTO techStack) {
        this.techStack = techStack;
    }

    @Override
    public String toString() {
        return "MemberTechStackDetailDTO{" +
                "stackCode=" + stackCode +
                ", memberId=" + memberId +
                ", techStack=" + techStack +
                '}';
    }
}
