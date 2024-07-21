package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.LoginMapper;
import com.i7.eatit.domain.user.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    private LoginMapper loginMapper;

    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    // 로그인
    public UserLoginDTO checkUser(UserLoginDTO userLoginDTO) {

        Map<String, String> userMap = new HashMap<>();

        userMap.put("userEmail", userLoginDTO.getEmail());
        userMap.put("userPassword", userLoginDTO.getPassword());

        return loginMapper.selectUser(userMap);
    }
}
