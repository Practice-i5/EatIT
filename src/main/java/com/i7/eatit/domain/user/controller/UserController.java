package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.dto.UserLoginDTO;
import com.i7.eatit.domain.user.dto.UserSignupDTO;
import com.i7.eatit.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login/*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
        단순 이동 메서드
     */

    // 메인로그인 페이지로 이동 (브랜드 이미지 클릭)
    @GetMapping("/loginMain")
    public void goLoginMain() {
    }

    @GetMapping("/main")
    public void goMain() {
    }

    @GetMapping("/findEmail")
    public void goFindEmail() {
    }

    @GetMapping("/findPwd")
    public void goFindPwd() {
    }

    @GetMapping("/join")
    public void goJoin() {
    }
    
    /*
        정보 전달 메서드
     */


    // 회원가입 - 이메일, 비밀번호, 이름, 전화번호,닉네임, 기술스택
    @PostMapping("/regist")
    public String join(UserSignupDTO userSignupDTO) {
        System.out.println("userSignupDTO = " + userSignupDTO);
        userService.UserSignUp(userSignupDTO);

        return "redirect:/login/loginMain";
    }

    // 로그인 - 이메일, 비밀번호
    @PostMapping("/login/authenticate")
    public String login(UserLoginDTO userLoginDTO) {
        userService.userLogin(userLoginDTO);
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