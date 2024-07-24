package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    UserInfoDTO findByUsername(String username);
    List<UserInfoDTO> findUsersByGroupId(@Param("groupId") Long groupId);
}