package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminLoginDto;
import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.service.AdminService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String adminLogin(HttpServletResponse response) {
        Cookie cookie = new Cookie("uuid", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "admin/adminLogin";
    }

    // 로그인 성공 시 세션을 생성하는 로직
    @PostMapping("/login")
    public String adminLogin(@ModelAttribute AdminLoginDto adminLoginDto,
        HttpServletRequest request, HttpServletResponse response) {

        // 1. 유효한 로그인인지 확인한다.
        if (!adminService.isValidAdminLogin(adminLoginDto)) {
            return "redirect:/admin/login";
        }

        // 2. Session 에 (UUID, email) 형태로 값을 저장한다.
        String uuid = UUID.randomUUID().toString();
        request.getSession().setAttribute(uuid, adminLoginDto.getAdminEmail());

        // 3. 사용자에게 key 값을 Cookie 형태로 전달
        Cookie uuidCookie = new Cookie("uuid", uuid);
        response.addCookie(uuidCookie);

        return "redirect:/admin/members";
    }

    @GetMapping("/members")
    public String getMembers(Model model, @RequestParam(required = false) String sort,
        @RequestParam(name = "searchEmail", required = false) String searchEmail,
        HttpServletRequest request) {

        String uuid = adminService.getUuidCookie(request);

        if (uuid == null) {
            return "redirect:/admin/login";
        }

        List<AdminMemberDto> adminMemberDtoList = adminService.findAllMember(sort, searchEmail);
        model.addAttribute("adminMemberDtoList", adminMemberDtoList);
        return "admin/members";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/admin/login";
    }

    // TODO: 신고 조회 위한 메서드
    @GetMapping("/complaints")
    public String findReports() {
        return "admin/complaints";
    }

    // TODO: 회원 관리 위한 메서드 (정지 혹은 복구)
    @GetMapping("/managements")
    public String clientManagement() {
        return "admin/managements";
    }
}
