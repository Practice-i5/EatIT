package com.i7.eatit.domain.meeting.model.service;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dao.MeetingMapper;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.dto.MemberLoadDTO;
import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingService {

    MeetingMapper meetingMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;


    public MeetingService(MeetingMapper meetingMapper) {
        this.meetingMapper = meetingMapper;
    }

    // 모임 등록
    @Transactional // create, update, delete 기능 뒤에 붙이기
    public void createNewMeeting(MeetingDTO meeting) {
        meetingMapper.registMeeting(meeting);
    }

    // 모임의 관심분야 등록
    @Transactional
    public void createNewInterestsRel(InsertInterestRelDTO interestsRelDTO) {
        meetingMapper.registInterests(interestsRelDTO);
    }

    // 모임 참가
    @Transactional
    public void participateGuest(int meetingId, int memberId){
        meetingMapper.participateGuest(meetingId, memberId);
    }

    //사진등록
    @Transactional
    public void uploadMeetingPhoto(MeetingPhotoDTO meetingPhoto) {
        meetingMapper.uploadMeetingPhoto(meetingPhoto);
    }


    @Transactional
    public void participateHost(int meetingId, int member_id) {
        meetingMapper.participateHost(meetingId, member_id);
    }

    public String findMeetingPhotoById(int meetingId) { return meetingMapper.findMeetingPhotoById(meetingId); }

    public List<MeetingDTO> findAllMeetings() { return meetingMapper.findAllMeetings(); }

    public List<MeetingDTO> searchMeetings(SearchCriteria searchCriteria) { return meetingMapper.findMeetings(searchCriteria); }

    // meeting_id로 관심분야 검색
    public List<String> findInterestsById(int meetingId) { return meetingMapper.findInterestsById(meetingId);  }

    // meeting_id로 모임 하나 검색
    public MeetingDTO findMeetingById(int meetingId) { return meetingMapper.findMeetingById(meetingId);}

    // meeting 이름 검색
    public String findMeetingNameById(int meetingId) { return meetingMapper.findMeetingNameById(meetingId); }

    // 검색으로 meeting-list불러오기
    public List<PreviewMeetingDTO> findPreviewBySearch(SearchCriteria searchCriteria) {return meetingMapper.findPreviewBySearch(searchCriteria); };

    // 열려있는 참여중인 목록 불러오기
    public List<PreviewMeetingDTO> findPreviewByMemberIdOpen(int memberId) {return meetingMapper.findPreviewByMemberIdOpen(memberId); };

    // 닫혀있는 참여한 목록 불러오기
    public List<PreviewMeetingDTO> findPreviewByMemberIdClosed(int memberId) {return meetingMapper.findPreviewByMemberIdClosed(memberId); };

    public int findHostIdById(int meetingId) { return meetingMapper.findHostIdById(meetingId); }

    public List<String> findAllInterests() { return meetingMapper.findAllInterests();}

    public List<String> findAllType() { return meetingMapper.findAllType(); }

    public PreviewMeetingDTO findPreviewById(int meetingId) { return meetingMapper.findPreviewById(meetingId);}

    public String isExistAlarm(int meetingId, int memberId) { return meetingMapper.isExistAlarm(meetingId, memberId);}

    public String isExistPart(int meetingId, int memberId) { return meetingMapper.isExistPart(meetingId, memberId); }
    @Transactional
    public void upCountRecruiterNum(int meetingId) { meetingMapper.upCountRecruiterNum(meetingId);}
    @Transactional
    public void increaseMeetingReport(int meetingId) { meetingMapper.increaseMeetingReport(meetingId);}
    @Transactional
    public void increaseMemberReport(int memberId) { meetingMapper.increaseMemberReport(memberId);}

    public List<MemberLoadDTO> loadMembersById(int meetingId) {return meetingMapper.loadMembersById(meetingId);}
}


//    public MeetingDTO searchMeetingById(Long id) {}


