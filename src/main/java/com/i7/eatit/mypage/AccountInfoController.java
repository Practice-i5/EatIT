package com.i7.eatit.mypage;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.ProfileModifyService;
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

    private ProfileModifyService profileModifyService;

    public AccountInfoController(ProfileModifyService profileModifyService) {
        this.profileModifyService = profileModifyService;
    }

    @GetMapping("account-info")
    public void accountInfo(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model){

        if (loginUser!=null){
            model.addAttribute("loginMethod", "homepage");
        }
    }

    @PostMapping("account-info-modify")
    public String accountInfoModify(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, WebRequest request,
                                    RedirectAttributes rttr){

//        for (var it: request.getParameterMap().keySet()) {
//            System.out.println(it +":" + request.getParameter(it));
//        }
        if (!loginUser.getPassword().equals(request.getParameter("passwordBefore"))){
            rttr.addFlashAttribute("error_passwordBefore", " 올바른 비밀번호를 입력하세요");
        } else if (!Objects.equals(request.getParameter("passwordAfter"), request.getParameter("passwordAfterAgain"))){
            rttr.addFlashAttribute("error_passwordAgain", "비밀번호를 동일하게 입력해주세요.");
        } else{
            //유효한 비밀번호 입력함
            profileModifyService.modifyPassword(loginUser.getMember_id()
                    ,request.getParameter("passwordAfter"));
            loginUser.setPassword(request.getParameter("passwordAfter"));
            rttr.addFlashAttribute("passwordChangeMessage", "비밀번호를 변경했습니다.");
        }

        return "redirect:/my-page/account-info";
    }

    @GetMapping("account-info-social")
    public String accountSocialInfo() {
        return "my-page/account-info";
    }
}
