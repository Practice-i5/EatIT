package com.i7.eatit.mypage;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/my-page/*")
public class AccountInfoController {

    @GetMapping("account-info")
    public void accountInfo(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model){

        model.addAttribute("loginMethod", "homepage");
    }

    @GetMapping("account-info-social")
    public String accountSocialInfo() {
        return "my-page/account-info";
    }
}
