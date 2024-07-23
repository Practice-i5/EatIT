package com.i7.eatit.admin.service;

import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.mapper.AdminMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<AdminMemberDto> findAllMember(String sort, String searchEmail) {
        return adminMapper.findAllMember(sort, searchEmail);
    }
}