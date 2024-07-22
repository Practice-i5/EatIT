package com.i7.eatit.domain.meeting.model.dao;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeetingMapper {

    void registMeeting(MeetingDTO meeting);
}
