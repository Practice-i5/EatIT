package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileModifyMapper {

    void updateProfile(ProfileModifyDTO profile);
}
