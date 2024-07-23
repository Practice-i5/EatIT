package com.i7.eatit.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-page/*")
public class AccountInfoController {

    @GetMapping("account-info")
    public void accountInfo(Model model){
        model.addAttribute("loginMethod", "homepage");
    }

    @GetMapping("account-info-social")
    public String accountSocialInfo() {
        return "my-page/account-info";
    }
}
