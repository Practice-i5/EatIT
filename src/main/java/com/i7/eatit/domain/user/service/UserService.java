package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.UserMapper;
import com.i7.eatit.domain.user.dto.UserSignupDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    // 회원가입
    public void SignUp(UserSignupDTO userSignupDTO) {
        userMapper.userInsert(userSignupDTO);
    }
}
