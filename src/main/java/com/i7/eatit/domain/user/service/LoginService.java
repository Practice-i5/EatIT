package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.LoginMapper;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {

    private LoginMapper loginMapper;

    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    // 로그인
    public UserInfoDTO checkUser(UserLoginDTO loginUser) {

        // userLoginDTO 로 조회 후 JoinDTO 로 반환

        // 맵 형태로 전달
        Map<String, String> userMap = new HashMap<>();

        // Mapper 에 전달할 값을 JoinDTO 에
        userMap.put("email", loginUser.getEmail());
        userMap.put("password", loginUser.getPassword());

        // 요청 확인용
        System.out.println("===" + loginMapper.selectUser(userMap) + "===");

        return loginMapper.selectUser(userMap);
    }

    // 이메일 찾기
    public String findEmail(String name, String phoneNumber) {

        // 문자열 형태로 이메일을 반환
        return loginMapper.selectUserEmail(name, phoneNumber);

    }

    // 비밀번호 찾기
    public String findPassword(String email, String name, String phoneNumber) {

        Map<String, String> userPasswordMap = new HashMap<>();
        userPasswordMap.put("email", email);
        userPasswordMap.put("name", name);
        userPasswordMap.put("phoneNumber", phoneNumber);
        userPasswordMap.put("password", randomPassword());
        // 문자열 형태로 비밀번호를 반환
        return loginMapper.updateUserRandomPassword(userPasswordMap);
    }

    // 영어 + 숫자 랜덤 난수 생성
    private String randomPassword() {
        Random random = new Random();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(random.nextInt(10)));
        }
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf((char) (random.nextInt(26) + 65)));
        }

        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }
}
