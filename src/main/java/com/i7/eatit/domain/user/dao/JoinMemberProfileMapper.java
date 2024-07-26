package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface JoinMemberProfileMapper {

    List<JoinMemberProfileDTO> findJoinUser(int meetingId);

}
