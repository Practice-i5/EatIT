package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserLoginDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {

    // 로그인
    UserLoginDTO selectUser(Map<String, String> user);
}
