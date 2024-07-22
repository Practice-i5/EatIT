package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.LoginMapper;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
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
    public UserInfoDTO checkUser(UserLoginDTO loginUser) {
        
        // userLoginDTO 로 조회 후 JoinDTO 로 반환

        // 반환할 SessionDTO 생성
        UserInfoDTO userSessionDTO = new UserInfoDTO();
        
        // 맵 형태로 전달
        Map<String, String> userMap = new HashMap<>();
        
        // Mapper 에 전달할 값을 JoinDTO 에
        userMap.put("email",loginUser.getEmail());
        userMap.put("password", loginUser.getPassword());

        // 요청 확인용
        System.out.println("==="+loginMapper.selectUser(userMap) + "===");

        return loginMapper.selectUser(userMap);
    }
}
