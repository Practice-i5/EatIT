package com.i5.eatit;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/*")
public class LoginController {

    @GetMapping("/loginMain.html")
    public String loginMain() {

        return "login/loginMain"; // "loginMain"을 반환하여 뷰 리졸버가 "login/loginMain.html"을 찾도록 합니다.
    }

    @GetMapping("/findPwd")
    public String findPwd() {

        return "login/findPwd"; // "findPwd"를 반환하여 뷰 리졸버가 "login/findPwd.html"을 찾도록 합니다.
    }

    @GetMapping("/join")
    public String goJoin() {

        return "login/join"; // "findPwd"를 반환하여 뷰 리졸버가 "login/findPwd.html"을 찾도록 합니다.
    }

    @GetMapping("/findEmail")
    public String findEmail() {

        return "login/findEmail"; // "findEmail"을 반환하여 뷰 리졸버가 "login/findEmail.html"을 찾도록 합니다.
    }
}
