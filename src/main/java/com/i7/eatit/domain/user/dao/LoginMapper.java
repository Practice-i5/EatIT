package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {

    // 로그인
    UserInfoDTO selectUser(Map<String, String> user);

    // 이메일 찾기
    String selectUserEmail(String name, String phoneNumber);

    // 비밀번호 변경 후 db에 적용
    void updateUserRandomPassword(Map<String, String> userPasswordMap);
}
