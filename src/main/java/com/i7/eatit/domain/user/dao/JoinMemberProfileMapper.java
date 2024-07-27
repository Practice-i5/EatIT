package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JoinMemberProfileMapper {

    List<JoinMemberProfileDTO> findJoinUser(@Param("meetingId") int meetingId);

}
