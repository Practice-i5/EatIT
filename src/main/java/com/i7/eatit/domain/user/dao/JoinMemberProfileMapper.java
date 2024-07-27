package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;
import com.i7.eatit.domain.user.dto.RevieweeProfileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinMemberProfileMapper {

    List<JoinMemberProfileDTO> findJoinUser(int meetingId);

    List<RevieweeProfileDTO> findJoinUserModal(int meetingId);

}
