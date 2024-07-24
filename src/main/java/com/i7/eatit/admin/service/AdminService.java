package com.i7.eatit.admin.service;

import com.i7.eatit.admin.dto.AdminDto;
import com.i7.eatit.admin.dto.AdminLoginDto;
import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.exception.AdminNotFoundException;
import com.i7.eatit.admin.mapper.AdminMapper;
import com.i7.eatit.admin.mapper.AdminMemberMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    AdminMemberMapper adminMemberMapper;
    AdminMapper adminMapper;

    public AdminService(AdminMemberMapper adminMemberMapper, AdminMapper adminMapper) {
        this.adminMemberMapper = adminMemberMapper;
        this.adminMapper = adminMapper;
    }

    public List<AdminMemberDto> findAllMember(String sort, String searchEmail) {
        return adminMemberMapper.findAllMember(sort, searchEmail);
    }

    public boolean isValidAdminLogin(AdminLoginDto adminLoginDto) {
        String email = adminLoginDto.getAdminEmail();
        String password = adminLoginDto.getAdminPassword();

        try {
            // 여기에서 에러 발생
            AdminDto adminDto = adminMapper.findByEmail(email);

            if (adminDto == null) {
                return false;
            }

            if (!adminDto.getPassword().equals(password)) {
                return false;
            }
        } catch (Exception e) {
            throw new AdminNotFoundException("Admin ID 를 찾을 수 없습니다.");
        }
        return true;
    }

    public String getUUIDCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uuid")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}