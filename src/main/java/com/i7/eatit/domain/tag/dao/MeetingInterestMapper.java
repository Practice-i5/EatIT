package com.i7.eatit.domain.tag.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MeetingInterestMapper {
    void insertMeetingInterest(Map<String,String> meetingInterest);

    void deleteMeetingInterestByMeetingId(int meetingId);
}
