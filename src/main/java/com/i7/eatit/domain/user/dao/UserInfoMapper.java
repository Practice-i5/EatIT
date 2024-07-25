package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.UserInfoDTO;

public interface UserInfoMapper {

    UserInfoDTO selectUserInfo(int userId);
}