package com.i7.eatit.admin.mapper;

import com.i7.eatit.admin.dto.AdminMeetingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMeetingMapper {

    List<AdminMeetingDto> findAllMeeting();

    AdminMeetingDto findMeetingById(int meetingId);

    void increaseMeetingReport(int meetingId);

    void updateMeetingStatus(int meetingId);

    void updateMeetingStatusToStop(int meetingId);
}