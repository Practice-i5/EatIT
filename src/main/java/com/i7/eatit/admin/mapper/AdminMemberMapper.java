package com.i7.eatit.admin.mapper;

import com.i7.eatit.admin.dto.AdminMemberDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMemberMapper {

    List<AdminMemberDto> findAllMember(@Param("sort") String sort,
        @Param("searchEmail") String searchEmail);

    AdminMemberDto findMemberById(int memberId);

    void updateMemberStatus(int memberId);
}