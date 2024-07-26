package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminLoginDto;
import com.i7.eatit.admin.dto.AdminMeetingDto;
import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.service.AdminService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final String REDIRECT_TO_LOGIN = "redirect:/admin/login";

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // 로그인 페이지로 이동하면 기존에 로그인이 되어 있던 유저도 로그아웃을 시켜야 함.
    @GetMapping("/login")
    public String adminLogin(HttpServletRequest request, HttpServletResponse response) {
        // 1. 로그인이 되어있는 관리자의 쿠키를 만료시킨다.
        Cookie adminLoginCookie = new Cookie("adminLogin", null);
        adminLoginCookie.setMaxAge(0);
        response.addCookie(adminLoginCookie);

        // 2. 세션을 만료시킨다.
        HttpSession session = request.getSession();
        session.invalidate();

        return "admin/adminLogin";
    }

    // 로그인 성공 시 세션을 생성하는 로직
    @PostMapping("/login")
    public String adminLogin(@ModelAttribute AdminLoginDto adminLoginDto,
        HttpServletRequest request, HttpServletResponse response) {

        // 1. 유효한 로그인인지 확인한다.
        if (!adminService.isValidAdminLogin(adminLoginDto)) {
            return REDIRECT_TO_LOGIN;
        }

        // 2. Session 에 ("adminSession_" + 세션 아이디, 어드민의 이메일) 형식으로 저장해 둔다.
        // HttpSession 은 Java Servlet APi 에서 제공하는 세션 관리의 구체적인 구현이다.
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("adminSession_" + httpSession.getId(),
            adminLoginDto.getAdminEmail());
        httpSession.setMaxInactiveInterval(60 * 30);

        // 3. 사용자가 세션에 접근할 수 있도록 Session 의 Key 값을 Cookie 의 Value 값으로 전달.
        Cookie adminLoginCookie = new Cookie("adminLoginCookie", httpSession.getId());
        adminLoginCookie.setPath("/admin"); // admin 으로 시작하는 path 에서만 쿠키가 유효함.
        adminLoginCookie.setMaxAge(60 * 30);
        response.addCookie(adminLoginCookie);

        return "redirect:/admin/members";
    }

    @GetMapping("/members")
    public String findAllMember(Model model,
        @RequestParam(name = "sort", required = false) String sort,
        @RequestParam(name = "searchEmail", required = false) String searchEmail,
        HttpServletRequest request) {

        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }

        List<AdminMemberDto> adminMemberDtoList = adminService.findAllMember(sort, searchEmail);
        model.addAttribute("adminMemberDtoList", adminMemberDtoList);
        return "admin/members";
    }

    // 회원 단일 조회 위한 Controller
    @GetMapping("/members/{memberId}")
    public String findMember(@PathVariable(name = "memberId") int memberId, Model model,
        HttpServletRequest request) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }
        AdminMemberDto adminMemberDto = adminService.findMemberById(memberId);
        model.addAttribute("adminMemberDto", adminMemberDto);
        return "admin/member";
    }

    // 회원을 정지시키기 위한 페이지
    @GetMapping("/members/{memberId}/management")
    public String clientManagement(@PathVariable(name = "memberId") int memberId,
        HttpServletRequest request
    ) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }
        adminService.updateMemberStatus(memberId);
        return "redirect:/admin/members";
    }

    // 전체 모임 조회
    @GetMapping("/meetings")
    public String findMeetings(HttpServletRequest request, Model model) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }

        List<AdminMeetingDto> adminMeetingDtoList = adminService.findAllMeeting();
        model.addAttribute("adminMeetingDtoList", adminMeetingDtoList);
        return "admin/meetings";
    }

    // 모임 단일 조회
    @GetMapping("/meetings/{meetingId}")
    public String findMeetingById(HttpServletRequest request, Model model,
        @PathVariable(name = "meetingId") int meetingId) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }

        AdminMeetingDto adminMeetingDto = adminService.findMeetingById(meetingId);
        model.addAttribute("adminMeetingDto", adminMeetingDto);
        return "admin/meeting";
    }

    @GetMapping("/meetings/{meetingId}/management")
    public String changeMeetingStatus(@PathVariable int meetingId, Model model) {
        adminService.changeMeetingStatus(meetingId);
        return "redirect:/admin/meetings/" + meetingId;
    }

    @GetMapping("api/admin/meetings/{meetingId}/increaseReport")
    public String increaseMeetingReport(@PathVariable int meetingId) {
        adminService.increaseMeetingReport(meetingId);
        adminService.changeMeetingStatus(meetingId);
        return "redirect:/index.html";
    }

    @GetMapping("api/admin/members/{memberId}/increaseReport")
    public String increaseMemberReport(@PathVariable int memberId) {
        adminService.increaseMemberReport(memberId);
        adminService.changeMemberStatus(memberId);
        return "redirect:/index.html";
    }
}