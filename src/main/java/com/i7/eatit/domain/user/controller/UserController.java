package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.dto.UserLoginDTO;
import com.i7.eatit.domain.user.dto.UserSignupDTO;
import com.i7.eatit.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 - 이메일, 비밀번호, 이름, 전화번호,닉네임, 기술스택
    @PostMapping("/login/regist")
    public String join(UserSignupDTO userSignupDTO) {

        userService.SignUp(userSignupDTO);

        return "redirect:/login/loginMain";
    }

    // 로그인 - 이메일, 비밀번호
    @PostMapping("/login/authenticate")
    public String login(UserLoginDTO userLoginDTO) {

        return "/main";
    }
}




/*
@RequestParam("email") String email,
@RequestParam("password") String password,
@RequestParam("name") String name,
@RequestParam("phoneNumber") int phoneNumber,
@RequestParam("nickname") String nickname
 */