package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.UserMapper;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserInfoDTO getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public List<UserInfoDTO> getUsersByGroupId(Long groupId) {
        return userMapper.findUsersByGroupId(groupId);
    }
}