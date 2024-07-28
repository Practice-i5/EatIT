package com.i7.eatit.mypage;

import com.i7.eatit.domain.relationship.dto.BlockInfoDetailDTO;
import com.i7.eatit.domain.relationship.service.UserBlockService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/my-page/*")
public class BlackListController {


    private UserBlockService userBlockService;

    public BlackListController(UserBlockService userBlockService) {
        this.userBlockService = userBlockService;
    }

    @GetMapping("black-list")
    public void blackList(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model ) {

        if (loginUser != null) {
            List<BlockInfoDetailDTO> blockUserList = userBlockService.findBlockedMemberById(loginUser.getMember_id());
            System.out.println(blockUserList);
            model.addAttribute("blockUserList", blockUserList);
        }

    }

    @PostMapping("block-user-delete")
    public String followUserDelete(@RequestParam("memberId") int blockedMemberId, @SessionAttribute("loginUser") UserInfoDTO loginUser){

        System.out.println("로그인 유저 id : " +loginUser.getMember_id());
        System.out.println("차단 취소 대상 id : "+blockedMemberId);
        userBlockService.deleteBlockMember(loginUser.getMember_id(),blockedMemberId);

        return "redirect:/my-page/black-list";
    }

}
