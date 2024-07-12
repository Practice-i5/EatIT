package com.ohgiraffers.loginpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/FindEmail")
    public String findEmail() {

        // 비즈니스 로직을 처리하거나 필요한 데이터를 모델에 추가
        // 여기서는 "findEmail"이라는 이름의 템플릿을 반환

        return "FindEmail"; // FindEmail.html 템플릿 반환
    }


    @GetMapping("/FindPwd")
    public String findPwd() {

        return "FindPwd"; // FindPwd.html 템플릿 반환
    }

    @GetMapping("/Join")
    public String findJoin() {

        return "Join"; // Join.html 템플릿 반환
    }

    @PostMapping("/register")
    public String registerUser() {
        // 회원가입 처리 로직 추가
        // 예: 사용자 데이터 저장

        return "redirect:/login"; // 회원가입 성공 후 로그인 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html 템플릿 반환
    }
}