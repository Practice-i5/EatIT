package com.i7.eatit.domain.tag.dao;

import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import com.i7.eatit.domain.tag.dto.MemberTechStackDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberTechStackMapper {

    List<MemberTechStackDetailDTO> findMemberTechStack(int memberId);

    void addMemberTechStack(MemberTechStackDTO memberTechStack);

    void deleteMemberTechStack(int memberId);

}
