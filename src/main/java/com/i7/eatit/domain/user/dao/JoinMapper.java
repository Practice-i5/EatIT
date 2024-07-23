package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {

    // 회원가입
    void userInsert(UserInfoDTO userInfoDTO);
}
