package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.service.FindUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class FindUser {

    private FindUserService findUserService;

    public FindUser(FindUserService findUserService) {
        this.findUserService = findUserService;
    }


    // 이메일로 유저 찾기
    @PostMapping("/findUserById")
    public String findUserById(@RequestParam("email") String email) {

        findUserService.findUserById(email);

        return "findUserById";
    }
}
