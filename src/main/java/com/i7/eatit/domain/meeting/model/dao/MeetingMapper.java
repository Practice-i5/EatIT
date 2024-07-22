package com.i7.eatit.domain.meeting.model.dao;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.*;
import java.util.List;

@Mapper
public interface MeetingMapper {

    List<MeetingDTO> findAllMeetings();

    void registMeeting(MeetingDTO meeting);
}
