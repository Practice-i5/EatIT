package com.i7.eatit.admin.mapper;

import com.i7.eatit.admin.dto.AdminMemberDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    List<AdminMemberDto> findAllMember(String sort, String searchEmail);
}