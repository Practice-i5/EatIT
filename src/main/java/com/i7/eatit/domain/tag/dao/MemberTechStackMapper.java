package com.i7.eatit.domain.tag.dao;

import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberTechStackMapper {

    void addMemberTechStack(MemberTechStackDTO memberTechStack);

    void deleteMemberAllTechStack(int memberId);
}
