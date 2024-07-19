package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.service.AdminService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService; // 필드가 null 이 되는 것을 방지하기 위함.

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String adminLogin(Model model) {
        model.addAttribute("admin", "test");
        return "admin/adminLogin";
    }

    // TODO: 회원 전체를 조회하기 위한 메서드
    @GetMapping("/members")
    public String getClients(Model model) {

//        List<AdminMemberDto> adminMemberDtoList = adminService.findAll();
        Map<String, Integer> map = new HashMap<>();

        Random random = new Random();
        List<AdminMemberDto> adminMemberDtoList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            AdminMemberDto adminMemberDto = new AdminMemberDto();
            adminMemberDto.setUserId("user" + i + "@example.com");
            adminMemberDto.setUserName("randomName" + i);
            adminMemberDto.setRole("USER");
            adminMemberDto.setLockedAccount(false);
            adminMemberDto.setReportedCount(random.nextInt(10));
            adminMemberDto.setPenaltyScore(random.nextInt(5));
            adminMemberDto.setTryLogin(random.nextInt(5));
            adminMemberDto.setJoinDate(new Date(System.currentTimeMillis()));

            adminMemberDtoList.add(adminMemberDto);
        }
        model.addAttribute("adminUserDtoList", adminMemberDtoList);
        return "admin/clients";
    }

//    // TODO: 신고 조회 위한 메서드
//    @GetMapping("/complaints")
//    public String findReports(Model model) {
//        return "admin/complaints";
//    }
//
//    // TODO: 회원 관리 위한 메서드 (정지 혹은 복구)
//    @GetMapping("/managements")
//    public String clientManagement(Model model) {
//        return "admin/managements";
//    }
}
