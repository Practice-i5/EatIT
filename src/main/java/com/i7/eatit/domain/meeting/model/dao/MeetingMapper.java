package com.i7.eatit.domain.meeting.model.dao;

import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeetingMapper {

    List<MeetingDTO> findAllMeetings();

    List<MeetingDTO> findMeetings(SearchCriteria searchCriteria);

    void registMeeting(MeetingDTO meeting);

    void registInterests(InsertInterestRelDTO interestRel);

    List<String> findInterestsById(int meetingId);

    MeetingDTO findMeetingById(int meetingId);

    String findMeetingNameById(int meetingId);
}
