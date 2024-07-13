package com.i5.eatit;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login/*")
public class LoginController {

    // 로그인 메인홈으로 이동
    @GetMapping("/loginMain")
    public String loginMain() {

        return "login/loginMain"; // "loginMain"을 반환하여 뷰 리졸버가 "login/loginMain.html"을 찾도록 합니다.
    }


    // 비밀번호를 찾는 창으로 이동
    @GetMapping("/findPwd")
    public String findPwd() {

        return "login/findPwd"; // "findPwd"를 반환하여 뷰 리졸버가 "login/findPwd.html"을 찾도록 합니다.
    }

    // 회원가입 창으로 이동
    @GetMapping("/join")
    public String goJoin() {

        return "login/join"; // "findPwd"를 반환하여 뷰 리졸버가 "login/findPwd.html"을 찾도록 합니다.
    }

    // 이메일을 찾는 창으로 이동
    @GetMapping("/findEmail")
    public String findEmail() {

        return "login/findEmail"; // "findEmail"을 반환하여 뷰 리졸버가 "login/findEmail.html"을 찾도록 합니다.
    }

    // 이름과 전화번호로 이메일 조회
    @GetMapping("/readEmail")
    public String readEmail(Model model,
                            @RequestParam String email,
                            @RequestParam String password) {

        // 조회 후 이메일, 비밀번호가 있으면 로그인 후 메인화면 으로 이동

        return "/main";
    }

    // 이름과 전화번호로 이메일 조회
    @PostMapping("/readEmail")
    public String readEmail(Model model,
                            @RequestParam String name,
                            @RequestParam int phoneNo) {

        // 조회 후 이름과 전화번호가 있으면 이메일을 화면에 출력
        
        return "redirect:/login/loginMain";
    }

    // 이메일, 이름, 전화번호로 비밀번호 변경 후 이메일로 전송 -> 로그인 메인 창으로 이동하기
    @PostMapping("/readPassword")
    public String readPassword(Model model,
                               @RequestParam String email,
                               @RequestParam String name,
                               @RequestParam int phoneNo) {

        // 조회 후 이메일, 이름, 전화번호가 있으면 비밀번호 변경 후 이메일로 전송했다는 메세지를 화면에 출력
        // -> 로그인 메인 화면으로 이동
        
        return "redirect:/login/loginMain";
    }

    // 회원가입 후 정보 추가 -> 로그인 메인 홈으로 이동
    @PostMapping("/regist")
    public String regist(Model model,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam String name,
                         @RequestParam String nickname,
                         @RequestParam int phoneNo) {

        // 조회 후 중복된 값이 없으면 DTO 에 추가

        return "redirect:/login/loginMain";
    }
}
