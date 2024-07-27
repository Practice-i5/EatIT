package com.i7.eatit.domain.meeting.model.dto;

import java.util.List;

public class PartMemDTO {

    private int meetingId;
    private MemberLoadDTO hostLoadDTO;
    private List<MemberLoadDTO> memberLoadDTOList;

    public PartMemDTO() {}

    public PartMemDTO(int meetingId, MemberLoadDTO hostLoadDTO, List<MemberLoadDTO> memberLoadDTOList) {
        this.meetingId = meetingId;
        this.hostLoadDTO = hostLoadDTO;
        this.memberLoadDTOList = memberLoadDTOList;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public MemberLoadDTO getHostLoadDTO() {
        return hostLoadDTO;
    }

    public void setHostLoadDTO(MemberLoadDTO hostLoadDTO) {
        this.hostLoadDTO = hostLoadDTO;
    }

    public List<MemberLoadDTO> getMemberLoadDTOList() {
        return memberLoadDTOList;
    }

    public void setMemberLoadDTOList(List<MemberLoadDTO> memberLoadDTOList) {
        this.memberLoadDTOList = memberLoadDTOList;
    }

    @Override
    public String toString() {
        return "PartMemDTO{" +
                "meetingId=" + meetingId +
                ", hostLoadDTO=" + hostLoadDTO +
                ", memberLoadDTOList=" + memberLoadDTOList +
                '}';
    }
}
