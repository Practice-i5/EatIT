package com.i7.eatit.admin.service;

import com.i7.eatit.admin.dto.AdminDto;
import com.i7.eatit.admin.dto.AdminLoginDto;
import com.i7.eatit.admin.dto.AdminMeetingDto;
import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.exception.AdminNotFoundException;
import com.i7.eatit.admin.mapper.AdminMapper;
import com.i7.eatit.admin.mapper.AdminMeetingMapper;
import com.i7.eatit.admin.mapper.AdminMemberMapper;
import com.i7.eatit.admin.util.SHA256Util;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    AdminMapper adminMapper;
    AdminMemberMapper adminMemberMapper;
    AdminMeetingMapper adminMeetingMapper;

    public AdminService(AdminMemberMapper adminMemberMapper, AdminMapper adminMapper,
        AdminMeetingMapper adminMeetingMapper) {
        this.adminMemberMapper = adminMemberMapper;
        this.adminMapper = adminMapper;
        this.adminMeetingMapper = adminMeetingMapper;
    }

    public List<AdminMemberDto> findAllMember(String sort, String searchEmail) {
        return adminMemberMapper.findAllMember(sort, searchEmail);
    }

    public boolean isValidAdminLogin(AdminLoginDto adminLoginDto) {
        try {
            AdminDto adminDto = adminMapper.findByEmail(adminLoginDto.getAdminEmail());

            if (adminDto == null) {
                log.info("아이디가 일치하지 않습니다.");
                return false;
            }

            if (!adminDto.getPassword()
                .equals(SHA256Util.encryptSHA256(adminLoginDto.getAdminPassword()))) {
                log.info("비밀번호가 일치하지 않습니다.");
                return false;
            }
        } catch (Exception e) {
            throw new AdminNotFoundException("Admin ID 를 찾을 수 없습니다.");
        }
        return true;
    }

    public boolean isAdminLoggedIn(HttpServletRequest request) {

        // 1. Cookie 가 없으면 로그인을 할 수 없다.
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }

        // 2. Cookie 는 있는데 세션이 없어도 로그인을 할 수 없다.
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("adminLoginCookie")) {
                String sessionId = cookie.getValue();
                HttpSession session = request.getSession();
                if (session.getAttribute("adminSession_" + sessionId) != null) {
                    // 3. 정상적으로 로그인을 잘 했다면, 세션과 쿠키의 만료 시간을 늘려 준다.
                    session.setMaxInactiveInterval(60 * 30);
                    cookie.setMaxAge(60 * 30);
                    return true;
                }
            }
        }
        // 4. 이 외의 모든 경우에는 로그인을 허용하지 않는다.
        return false;
    }

    public AdminMemberDto findMemberById(int memberId) {
        return adminMemberMapper.findMemberById(memberId);
    }

    public void updateMemberStatus(int memberId) {
        adminMemberMapper.updateMemberStatus(memberId);
    }

    public List<AdminMeetingDto> findAllMeeting() {
        return adminMeetingMapper.findAllMeeting();
    }

    public AdminMeetingDto findMeetingById(int meetingId) {
        return adminMeetingMapper.findMeetingById(meetingId);
    }

    public void changeMeetingStatus(int meetingId) {
        adminMeetingMapper.changeMeetingStatus(meetingId);
    }

    public void increaseMeetingReport(int meetingId) {
        adminMeetingMapper.increaseMeetingReport(meetingId);
    }

    public void increaseMemberReport(int memberId) {
        adminMemberMapper.increaseMemberReport(memberId);
    }

    public void changeMemberStatus(int memberId) {
        adminMemberMapper.changeMemberStatus(memberId);
    }
}