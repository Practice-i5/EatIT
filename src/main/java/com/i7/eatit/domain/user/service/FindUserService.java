package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.FindMapper;

import java.util.HashMap;
import java.util.Map;

public class FindUserService {

    private FindMapper findMapper;

    public FindUserService(FindMapper findMapper) {
        this.findMapper = findMapper;
    }

    public void findUserById(String email) {

        Map<String, String> userEmail = new HashMap<>();
        userEmail.put("email", email);

        FindMapper.selectUserInfo(userEmail);
    }
}
