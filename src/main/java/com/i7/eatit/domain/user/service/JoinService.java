package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.JoinMapper;
import com.i7.eatit.domain.user.dto.JoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JoinService {

    private JoinMapper joinMapper;

    public JoinService(JoinMapper joinMapper) {
        this.joinMapper = joinMapper;
    }

    // 회원가입
    @Transactional
    public void UserSignUp(JoinDTO joinDTO) {
        joinMapper.userInsert(joinDTO);
    }
}
