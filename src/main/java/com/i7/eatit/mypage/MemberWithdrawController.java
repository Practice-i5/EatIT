package com.i7.eatit.mypage;


import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/my-page/*")
@Controller
public class MemberWithdrawController {
    @GetMapping("withdraw")
    public void withdrawPage(){}

//    @PostMapping("widthdraw")
//    public String widthdraw(@SessionAttribute("loginUser") UserInfoDTO loginUser, RedirectAttributes rttr){
//
//    }
}
