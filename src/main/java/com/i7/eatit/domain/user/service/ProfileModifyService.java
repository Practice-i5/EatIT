package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.ProfileModifyMapper;
import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import com.i7.eatit.domain.user.dto.TechExperienceDTO;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
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
    public List<TechExperienceDTO> findMemberTechExperience(int memberId){
        return profileModifyMapper.selectTechExperience(memberId);
    }

    @Transactional
    public void modifyTechExperience(TechExperienceDTO techExperience) {
        profileModifyMapper.updateTechExperience(techExperience);
    }


    @Transactional
    public void addTechExperience(TechExperienceDTO techExperience){
        profileModifyMapper.insertTechExperience(techExperience);

    }

    public void deleteTechExperience(int memberId, int experienceId) {
        Map<String, Integer> experienceInfo = new HashMap<>();
        experienceInfo.put("memberId", memberId);
        experienceInfo.put("experienceId", experienceId);
        profileModifyMapper.deleteTechExperience(experienceInfo);
    }
}
