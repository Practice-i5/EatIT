package com.i7.eatit.domain.picture.dao;

import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface PhotoMapper {

    MemberPhotoDTO findPhotoByMemberId(int memberId);

    void uploadMemberPhoto(MemberPhotoDTO memberPhoto);

    List<MeetingPhotoDTO> findPhotoByMeetingId(int meetingId);

    void uploadMeetingPhoto(MeetingPhotoDTO meetingPhoto);

    void deleteMeetingPhoto(int meetingId);

    void deleteOneMeetingPhoto(Map<String, Integer> photoMap);
}
