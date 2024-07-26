package com.i7.eatit.mypage;


import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.ProfileModifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/my-page/*")
@Controller
public class MemberWithdrawController {

    private ProfileModifyService profileModifyService;

    public MemberWithdrawController(ProfileModifyService profileModifyService) {
        this.profileModifyService = profileModifyService;
    }

    @GetMapping("withdraw")
    public void withdrawPage(){}

    @PostMapping("withdraw")
    public String withdraw(@SessionAttribute("loginUser") UserInfoDTO loginUser,
                           SessionStatus status, RedirectAttributes rttr){

        if(loginUser==null){
            return "redirect:/";
        } else{
            profileModifyService.withdraw(loginUser.getMember_id());

            status.setComplete();
            rttr.addFlashAttribute("withdrawMessage", "회원탈퇴 끝");
            return "redirect:/my-page/withdraw-done";
        }
    }

    @GetMapping("withdraw-done")
    public void withdrawDonePage() {}
}
