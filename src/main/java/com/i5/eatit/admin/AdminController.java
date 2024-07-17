package com.i5.eatit.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    // 추후 Get 메서드로 수정 예정
    @GetMapping("/clients")
    public String getClients(Model model) {

        Random random = new Random();
        List<AdminUserDto> adminUserDtoList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            AdminUserDto adminUserDto = AdminUserDto.builder()
                .userId("user" + i + "@example.com")
                .userName("randomName" + i)
                .role("USER")
                .isLockedAccount(false)
                .reportedCount(random.nextInt(10))
                .penaltyScore(random.nextInt(5))
                .tryLogin(random.nextInt(5))
                .joinDate(new Date(System.currentTimeMillis()))
                .build();

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
