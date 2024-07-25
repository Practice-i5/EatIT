package com.i7.eatit.domain.picture.dao;

import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PhotoMapper {

    MemberPhotoDTO findPhotoByMemberId(int memberId);

    void uploadMemberPhoto(MemberPhotoDTO memberPhoto);

    List<MeetingPhotoDTO> findPhotoByMeetingId(int meetingId);


}
