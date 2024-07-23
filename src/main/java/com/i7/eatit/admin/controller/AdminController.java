package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.service.AdminService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String adminLogin(/*HttpServletRequest httpServletRequest*/) {
//        Session session = httpServletRequest.getSession().getAttribute();
//        if (session == null) {
//            return "redirect:/login";
//        }
        return "admin/adminLogin";
    }

    @GetMapping("/members")
    public String getMembers(Model model, @RequestParam(required = false) String sort,
        @RequestParam(name = "searchEmail", required = false) String searchEmail) {
        // TODO : 내일 와서 검색 기능 추가해야 함.
        List<AdminMemberDto> adminMemberDtoList = adminService.findAllMember(sort, searchEmail);
        model.addAttribute("adminMemberDtoList", adminMemberDtoList);
        return "admin/members";
    }

    // TODO: 신고 조회 위한 메서드
    @GetMapping("/complaints")
    public String findReports(Model model) {
        return "admin/complaints";
    }

    // TODO: 회원 관리 위한 메서드 (정지 혹은 복구)
    @GetMapping("/managements")
    public String clientManagement(Model model) {
        return "admin/managements";
    }
}
