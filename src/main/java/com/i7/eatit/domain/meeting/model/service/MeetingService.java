package com.i7.eatit.domain.meeting.model.service;

import com.i7.eatit.domain.meeting.model.dao.MeetingMapper;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MeetingService {

    MeetingMapper meetingMapper;

    public MeetingService(MeetingMapper meetingMapper) {
        this.meetingMapper = meetingMapper;
    }

    @Transactional
    public void createNewMeeting(MeetingDTO meeting) {
        meetingMapper.registMeeting(meeting);
    }
}
