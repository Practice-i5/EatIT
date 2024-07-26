package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import com.i7.eatit.domain.user.dto.TechExperienceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProfileModifyMapper {

    void updateProfile(ProfileModifyDTO profile);

    void updatePassword(Map<String, String> info);

    void softDeleteMember(int memberId);

    void insertTechExperience(TechExperienceDTO techExperience);

    List<TechExperienceDTO> selectTechExperience(int memberId);
}
