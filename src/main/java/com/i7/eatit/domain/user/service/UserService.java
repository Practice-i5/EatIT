package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.UserMapper;
import com.i7.eatit.domain.user.dto.UserLoginDTO;
import com.i7.eatit.domain.user.dto.UserSignupDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    // 회원가입
    public void UserSignUp(UserSignupDTO userSignupDTO) {
        userMapper.userInsert(userSignupDTO);
    }

    public UserLoginDTO userLogin(UserLoginDTO userLoginDTO) {
        return userMapper.userSelect(userLoginDTO);
    }
}
