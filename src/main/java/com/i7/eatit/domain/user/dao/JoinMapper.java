package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.JoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {

    // 회원가입
    void userInsert(JoinDTO joinDTO);
}
