package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;

import java.util.List;

public interface JoinMemberProfileMapper {

    List<JoinMemberProfileDTO> findJoinUser(int meetingId);

}
