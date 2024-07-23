package com.i7.eatit.domain.relationship.dto;

import com.i7.eatit.domain.user.dto.UserPhotoProfileDTO;

import java.sql.Date;

public class BlockInfoDetailDTO {
    private int blockId;
    private int memberId;
    private java.sql.Date blockDate;
    private UserPhotoProfileDTO detailProfile;

    public BlockInfoDetailDTO() {}

    public BlockInfoDetailDTO(int blockId, int memberId, Date blockDate, UserPhotoProfileDTO detailProfile) {
        this.blockId = blockId;
        this.memberId = memberId;
        this.blockDate = blockDate;
        this.detailProfile = detailProfile;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(Date blockDate) {
        this.blockDate = blockDate;
    }

    public UserPhotoProfileDTO getDetailProfile() {
        return detailProfile;
    }

    public void setDetailProfile(UserPhotoProfileDTO detailProfile) {
        this.detailProfile = detailProfile;
    }

    @Override
    public String toString() {
        return "BlockInfoDetailDTO{" +
                "blockId=" + blockId +
                ", memberId=" + memberId +
                ", blockDate=" + blockDate +
                ", detailProfile=" + detailProfile +
                '}';
    }
}
