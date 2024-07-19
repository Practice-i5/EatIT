package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserSignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 회원가입
    void userInsert(UserSignupDTO userSignupDTO);



}
