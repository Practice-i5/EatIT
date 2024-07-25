package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.ProfileModifyMapper;
import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import com.i7.eatit.domain.user.dto.TechExperienceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    @Transactional
    public void modifyPassword(int memberId, String newPassword){
        Map<String, String> info = new HashMap<>();
        info.put("memberId", memberId+"");
        info.put("newPassword", newPassword);
        profileModifyMapper.updatePassword(info);
    }

    @Transactional
    public void withdraw(int memberId){
        profileModifyMapper.softDeleteMember(memberId);
    }

    @Transactional
    public void modifyTechExperience(TechExperienceDTO techExperience) {
        profileModifyMapper.insertTechExperience(techExperience);
    }



}
