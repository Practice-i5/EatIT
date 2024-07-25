package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.UserInfoMapper;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    private UserInfoMapper userInfoMapper;

    public UserInfoService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfoDTO getUserInfo(int userId) {

        userInfoMapper.selectUserInfo(userId);
        
        return userInfoMapper.selectUserInfo(userId);
    }
}
