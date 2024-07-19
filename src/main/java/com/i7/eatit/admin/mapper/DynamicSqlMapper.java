package com.i7.eatit.admin.mapper;

import com.i7.eatit.admin.dto.AdminMemberDto;
import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {

    List<AdminMemberDto> findAll(Map<String, Integer> map);
}
