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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // 1. 멤버 전체 조회
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

    // 2. 멤버 단일 조회
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

    // 3. 멤버 신고 횟수 증가 -> N회 이상 신고 누적 시 자동으로 시스템에 의해 멤버가 차단 됨.
    @GetMapping("api/members/{memberId}/increaseReport")
    public String increaseMemberReport(@PathVariable(name = "memberId") int memberId) {
        adminService.increaseMemberReport(memberId);
        // TODO : redirect Url 현민 님과 맞춰 봐야 함.
        return "redirect:/index.html";
    }

    // 4-1) 멤버 상태 변경 (정지 <-> 활성화)
    @GetMapping("/members/{memberId}/management")
    public String changeMemberStatus(@PathVariable(name = "memberId") int memberId,
        HttpServletRequest request
    ) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }
        adminService.updateMemberStatus(memberId);
        return "redirect:/admin/members";
    }

//    // 4-2) 멤버 상태 변경 (원래의 상태는 고려하지 않고 항상 정지 상태로 바꿈)
//    @GetMapping("/members/{memberId}/management/stop")
//    public String changeMemberStatusToStop(@PathVariable(name = "memberId") int memberId,
//        HttpServletRequest request
//    ) {
//        if (!adminService.isAdminLoggedIn(request)) {
//            return REDIRECT_TO_LOGIN;
//        }
//        adminService.updateMemberStatusToStop(memberId);
//        return "redirect:/admin/members";
//    }

    // 5. 모임 전체 조회
    @GetMapping("/meetings")
    public String findMeetings(HttpServletRequest request, Model model) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }

        List<AdminMeetingDto> adminMeetingDtoList = adminService.findAllMeeting();
        model.addAttribute("adminMeetingDtoList", adminMeetingDtoList);
        return "admin/meetings";
    }

    // 6. 모임 단일 조회
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

    // 7. 모임 신고 횟수 추가 -> N회 이상 신고 누적 시 자동으로 시스템에 의해 모임이 정지 됨.
    @GetMapping("api/meetings/{meetingId}/increaseReport")
    public String increaseMeetingReport(@PathVariable(name = "meetingId") int meetingId) {
        adminService.increaseMeetingReport(meetingId);
        return "redirect:/index.html";
    }

    // 8-1) 모임 상태 변경 (중지 <-> 활성화)
    @GetMapping("/meetings/{meetingId}/management")
    public String changeMeetingStatus(HttpServletRequest request,
        @PathVariable(name = "meetingId") int meetingId, Model model) {
        if (!adminService.isAdminLoggedIn(request)) {
            return REDIRECT_TO_LOGIN;
        }
        adminService.updateMeetingStatus(meetingId);
        return "redirect:/admin/meetings";
    }

//    // 8-2) 모임 상태 변경 (이전 상태를 고려하지 않고 항상 중지로 바꿈)
//    @GetMapping("/meetings/{meetingId}/management/close")
//    public String changeMeetingStatusToStop(HttpServletRequest request,
//        @PathVariable(name = "meetingId") int meetingId, Model model) {
//        adminService.updateMeetingStatusToClose(meetingId);
//        return "redirect:/admin/meetings";
//    }
}