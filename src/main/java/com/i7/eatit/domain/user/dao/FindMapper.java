package com.i7.eatit.domain.user.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

//@Mapper
public interface FindMapper {

    void selectUserInfo(Map<String, String> userEmail);
}