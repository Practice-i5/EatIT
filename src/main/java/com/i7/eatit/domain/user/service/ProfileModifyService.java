package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.ProfileModifyMapper;
import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileModifyService {

    private ProfileModifyMapper profileModifyMapper;

    public ProfileModifyService(ProfileModifyMapper profileModifyMapper) {
        this.profileModifyMapper = profileModifyMapper;
    }

    @Transactional
    public void modifyProfile(ProfileModifyDTO profile){
        profileModifyMapper.updateProfile(profile);

    }


}
