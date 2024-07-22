/*
package com.i7.eatit.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @GetMapping("login")
    public String adminLogin(Model model) {
        model.addAttribute("admin", "test");
        return "admin/login";
    }

    @PostMapping("client-list")
    public String adminClientList(Model model) {

        UserDTO userDTO = null;

        for (int i = 1; i <= 100; i++) {
            userDTO = new UserDTO();
            userDTO.setUserId("user"+ i + "@example.com");
            userDTO.setUserName("user" + i);
            userDTO.setRole("user");
            userDTO.setLockedAccount(false);
            userDTO.setReportedCount((int)(Math.random() * 10));
            userDTO.setPenaltyScore((int)(Math.random() * 10));
            userDTO.setTryLogin((int)(Math.random() * 5));
            userDTO.setJoinDate(new Date(System.currentTimeMillis()));
            model.addAttribute("user", userDTO);
        };
        return "admin/client-list";
    }
}
*/
