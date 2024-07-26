package com.i7.eatit.domain.meeting.model.dao;

import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dto.DetailMeetingDTO;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeetingMapper {

    List<MeetingDTO> findAllMeetings();

    List<String> findAllInterests();

    List<String> findAllType();

    List<MeetingDTO> findMeetings(SearchCriteria searchCriteria);

    // 모임 등록
    void registMeeting(MeetingDTO meeting);

    // 모임의 관심분야 등록
    void registInterests(InsertInterestRelDTO interestRel);

    // meeting_id로 관심분야 검색
    List<String> findInterestsById(int meetingId);

    // meeting_id로 모임 하나 검색
    MeetingDTO findMeetingById(int meetingId);

    // meeting 이름 검색
    String findMeetingNameById(int meetingId);

    // meeting_id로 host 정보 불러오기
    int findHostIdById(int meetingId);

    // 검색으로 meeting-list불러오기
    List<PreviewMeetingDTO> findPreviewBySearch(SearchCriteria searchCriteria);

    // 열려있는 참여중인 목록 불러오기
    List<PreviewMeetingDTO> findPreviewByMemberIdOpen(int memberId);

    // 닫혀있는 참여한 목록 불러오기
    List<PreviewMeetingDTO> findPreviewByMemberIdClosed(int memberId);

    // 모임 참가
    void participateGuest(@Param("meetingId") int meetingId, @Param("memberId") int memberId);

    void participateHost(@Param("meetingId") int meetingId, @Param("memberId") int memberId);

    PreviewMeetingDTO findPreviewById(int meetingId);

    String findMeetingPhotoById(@Param("meetingId") int meetingId);
//    DetailMeetingDTO findDetailMeetingContents(int meetingId);
//    List<> findParticipationts(int meetingId);
}
