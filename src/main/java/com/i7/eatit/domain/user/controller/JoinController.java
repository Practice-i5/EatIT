package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.dto.UserInfoDTO;

import com.i7.eatit.domain.user.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join/*")
public class JoinController {

    private JoinService joinService;

    public JoinController(JoinService loginService) {
        this.joinService = loginService;
    }


    // 회원가입 - 이메일, 비밀번호, 이름, 전화번호,닉네임, 기술스택
    @PostMapping("/regist")
    public String join(UserInfoDTO userInfoDTO) {

        System.out.println("userSignupDTO = " + userInfoDTO); // 확인용

        joinService.UserSignUp(userInfoDTO);

        return "redirect:/login/loginMain";
    }

}
