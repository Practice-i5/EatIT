package com.i7.eatit.admin.controller;

import com.i7.eatit.admin.dto.AdminUserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String adminLogin(Model model) {
        model.addAttribute("admin", "test");
        return "admin/adminLogin";
    }

    // TODO: 회원 전체를 조회하기 위한 메서드
    @GetMapping("/clients")
    public String getClients(Model model) {

        Random random = new Random();
        List<AdminUserDto> adminUserDtoList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            AdminUserDto adminUserDto = new AdminUserDto();
            adminUserDto.setUserId("user" + i + "@example.com");
            adminUserDto.setUserName("randomName" + i);
            adminUserDto.setRole("USER");
            adminUserDto.setLockedAccount(false);
            adminUserDto.setReportedCount(random.nextInt(10));
            adminUserDto.setPenaltyScore(random.nextInt(5));
            adminUserDto.setTryLogin(random.nextInt(5));
            adminUserDto.setJoinDate(new Date(System.currentTimeMillis()));

            adminUserDtoList.add(adminUserDto);
        }
        model.addAttribute("adminUserDtoList", adminUserDtoList);
        return "admin/clients";
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
