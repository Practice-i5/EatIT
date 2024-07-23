package com.i7.eatit.domain.user.dto;

import java.sql.Date;
import java.util.List;

public class BlockInfoDetailDTO {
    private int blockId;
    private int memberId;
    private java.sql.Date blockDate;
    private List<UserPhotoProfileDTO> blockedUserPhotoProfile;

    public BlockInfoDetailDTO() {
    }

    public BlockInfoDetailDTO(int blockId, int memberId, Date blockDate, List<UserPhotoProfileDTO> blockedUserPhotoProfile) {
        this.blockId = blockId;
        this.memberId = memberId;
        this.blockDate = blockDate;
        this.blockedUserPhotoProfile = blockedUserPhotoProfile;
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

    public List<UserPhotoProfileDTO> getBlockedUserPhotoProfile() {
        return blockedUserPhotoProfile;
    }

    public void setBlockedUserPhotoProfile(List<UserPhotoProfileDTO> blockedUserPhotoProfile) {
        this.blockedUserPhotoProfile = blockedUserPhotoProfile;
    }

    @Override
    public String toString() {
        return "BlockInfoDetailDTO{" +
                "blockId=" + blockId +
                ", memberId=" + memberId +
                ", blockDate=" + blockDate +
                ", blockedUserPhotoProfile=" + blockedUserPhotoProfile +
                '}';
    }
}
