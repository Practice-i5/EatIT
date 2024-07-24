package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.dto.UserPwdDTO;
import org.springframework.ui.Model;
import com.i7.eatit.domain.user.dto.UserLoginDTO;
import com.i7.eatit.domain.user.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login/*")
@SessionAttributes("loginUser")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /*
        단순 이동 메서드
     */

    // 메인로그인 페이지로 이동 (브랜드 이미지 클릭)
    @GetMapping("/loginMain")
    public void goLoginMain() {
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

    // 로그인 - 이메일, 비밀번호
    @PostMapping("/successLogin")
    public String login(UserLoginDTO userLoginDTO, Model model) {

        UserInfoDTO loginUser = loginService.checkUser(userLoginDTO);

        // 응답 확인용
        System.out.println(loginUser); // 확인용

        if (loginUser != null) {    // 성공

            model.addAttribute("loginUser", loginUser);

            return "redirect:/login/successLogin";

        } else {                    // 실패

            return "redirect:/login/loginMain";
        }
    }

    @GetMapping("/successLogin")
    public void successLogin() {
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {

        sessionStatus.setComplete(); // 세션 종료

        return "redirect:/login/loginMain";
    }

    // 이메일 찾기
    @PostMapping("/findEmail")
    public String findEmail(@RequestParam String name,
                            @RequestParam String phoneNumber,
                            RedirectAttributes redirectAttributes,
                            Model model) {

        // 이메일 조회
        String email = loginService.findEmail(name, phoneNumber);

        System.out.println("email = " + email);
        if (email != null) {    // 이메일 조회 성공
            model.addAttribute("message", "찾은 이메일: " + email);
            model.addAttribute("redirectUrl", "/login/loginMain");
        } else {                // 이메일 조회 실패
            model.addAttribute("message", "이메일을 찾을 수 없습니다.");
            model.addAttribute("redirectUrl", "/login/findEmail");
        }

        return "login/findEmail";  // 같은 페이지로 돌아감
    }

    // 비밀번호 찾기
    @PostMapping("/findPwd")
    public String findPassword(@RequestParam String email,
                               @RequestParam String name,
                               @RequestParam String phoneNumber,
                               Model model) {

        // UserPwdDTO userPwdDTO = new UserPwdDTO();

        // 비밀번호 조회
        String password = loginService.findPassword(email, name, phoneNumber);

        System.out.println("email = " + password);

        if (password != null) { // 비밀번호 재설정 성공
            model.addAttribute("message", "비밀번호가" + password + "로 변경되었습니다.");
            model.addAttribute("redirectUrl", "/login/loginMain");
        } else { // 비밀번호 조회 실패
            model.addAttribute("message", "입력하신 정보와 일치한 정보가 없습니다.");
            model.addAttribute("redirectUrl", "/login/findPwd");
        }

        return "login/findPwd";  // 같은 페이지로 돌아감
    }

}
