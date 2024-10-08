package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.picture.dao.PhotoMapper;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.user.dao.JoinMapper;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JoinService {

    private JoinMapper joinMapper;
    private PhotoMapper photoMapper;

    public JoinService(JoinMapper joinMapper, PhotoMapper photoMapper) {
        this.joinMapper = joinMapper;
        this.photoMapper = photoMapper;
    }

    // 회원가입
    @Transactional
    public void UserSignUp(UserInfoDTO userInfoDTO) {
        System.out.println(userInfoDTO);
        joinMapper.userInsert(userInfoDTO);
    }

    @Transactional
    public void initMemberImage(MemberPhotoDTO memberPhotoDTO){
        photoMapper.initMemberImage(memberPhotoDTO);
    }
}
