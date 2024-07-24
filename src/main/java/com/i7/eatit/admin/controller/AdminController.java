package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminLoginDto;
import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.service.AdminService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
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
        Cookie adminLoginCookie = new Cookie("adminLoginCookie", null);
        adminLoginCookie.setMaxAge(0);
        response.addCookie(adminLoginCookie);
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

        // 2. Session 에 ("adminSession_" + 세션 아이디, 어드민의 이메일) 형식으로 저장해 둔다.
        // HttpSession 은 Java Servlet APi 에서 제공하는 세션 관리의 구체적인 구현이다.
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("adminSession_" + httpSession.getId(),
            adminLoginDto.getAdminEmail());

        // 3. 사용자가 세션에 접근할 수 있도록 Session 의 Key 값을 Cookie 의 Value 값으로 전달.
        Cookie adminLoginCookie = new Cookie("adminLoginCookie", httpSession.getId());
        response.addCookie(adminLoginCookie);

        return "redirect:/admin/members";
    }

    @GetMapping("/members")
    public String getMembers(Model model, @RequestParam(required = false) String sort,
        @RequestParam(name = "searchEmail", required = false) String searchEmail,
        HttpServletRequest request) {

        if (!adminService.isAdminLoggedIn(request)) {
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
    public String findReports(HttpServletRequest request) {
        if (!adminService.isAdminLoggedIn(request)) {
            return "redirect:/admin/login";
        }

        return "admin/complaints";
    }

    // TODO: 회원 관리 위한 메서드 (정지 혹은 복구)
    @GetMapping("/managements")
    public String clientManagement(HttpServletRequest request) {
        if (!adminService.isAdminLoggedIn(request)) {
            return "redirect:/admin/login";
        }
        return "admin/managements";
    }
}
