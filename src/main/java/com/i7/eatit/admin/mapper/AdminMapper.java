package com.i7.eatit.admin.mapper;

import com.i7.eatit.admin.dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    AdminDto findByEmail(String email);
}
