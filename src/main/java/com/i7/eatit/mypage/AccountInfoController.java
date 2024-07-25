package com.i7.eatit.mypage;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/my-page/*")
public class AccountInfoController {

    @GetMapping("account-info")
    public void accountInfo(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model){

        if (loginUser!=null){
            model.addAttribute("loginMethod", "homepage");
        }
    }

    @PostMapping("account-info-modify")
    public String accountInfoModify(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, WebRequest request,
                                    RedirectAttributes rttr){

        for (var it: request.getParameterMap().keySet()) {
            System.out.println(it +":" + request.getParameter(it));
        }

        if (!Objects.equals(request.getParameter("passwordAfter"), request.getParameter("passwordAfterAgain"))){
            rttr.addFlashAttribute("error_passwordAgain", "비밀번호를 동일하게 입력해주세요.");
        }

        return "redirect:/my-page/account-info";
    }

    @GetMapping("account-info-social")
    public String accountSocialInfo() {
        return "my-page/account-info";
    }
}
