package com.i7.eatit.domain.meeting.model.service;

import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dao.MeetingMapper;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingService {

    MeetingMapper meetingMapper;

    public MeetingService(MeetingMapper meetingMapper) {
        this.meetingMapper = meetingMapper;
    }

    @Transactional // create, update, delete 기능 뒤에 붙이기
    public void createNewMeeting(MeetingDTO meeting) {
        meetingMapper.registMeeting(meeting);
    }

    public List<MeetingDTO> findAllMeetings() { return meetingMapper.findAllMeetings(); }

    public List<MeetingDTO> searchMeetings(SearchCriteria searchCriteria) { return meetingMapper.findMeetings(searchCriteria); }
//    public MeetingDTO searchMeetingById(Long id) {}

}
