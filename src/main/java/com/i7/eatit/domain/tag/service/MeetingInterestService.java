package com.i7.eatit.domain.tag.service;

import com.i7.eatit.domain.tag.dao.MeetingInterestMapper;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class MeetingInterestService {

    private MeetingInterestMapper meetingInterestMapper;

    public MeetingInterestService(MeetingInterestMapper meetingInterestMapper) {
        this.meetingInterestMapper = meetingInterestMapper;
    }

    @Transactional
    public void addMeetingInterest(InsertInterestRelDTO interestInfo){
        for (String interestCondition: interestInfo.getInterestsConditions()){
            Map<String, String> interestMap = new HashMap<>();
            interestMap.put("interest", interestCondition);
            interestMap.put("relationId", String.valueOf(interestInfo.getRelation_id()));
            interestMap.put("meetingId", String.valueOf(interestInfo.meeting_id));
            meetingInterestMapper.insertMeetingInterest(interestMap);
        }
    }

    @Transactional
    public void deleteMeetingInterest(int meetingId){
        meetingInterestMapper.deleteMeetingInterestByMeetingId(meetingId);
    }

    @Transactional
    public void updateMeetingInterest(InsertInterestRelDTO interestInfo) {
        deleteMeetingInterest(interestInfo.getMeeting_id());
        addMeetingInterest(interestInfo);
    }

}

