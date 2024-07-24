package com.i7.eatit.mypage;

import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import com.i7.eatit.domain.relationship.service.UserFollowService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/my-page/*")
@Controller
public class FollowListController {

    private final UserFollowService userFollowService;

    public FollowListController(UserFollowService userFollowService) {
        this.userFollowService = userFollowService;
    }

    @GetMapping("follow-list")
    public void followList(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model){

        if (loginUser != null){
            List<FollowInfoDetailDTO> followList = userFollowService.findFollowMember(loginUser.getMember_id());
            System.out.println(followList);
            model.addAttribute("followList", followList);
        }
    }

    @PostMapping("follow-user-delete")
    public String followUserDelete(@RequestParam("memberId") int followeeId, @SessionAttribute("loginUser") UserInfoDTO loginUser){

        System.out.println("받음");
        System.out.println("로그인 유저 id : " +loginUser.getMember_id());
        System.out.println("팔로우 취소 대상 id : "+followeeId);
        userFollowService.deleteFollowMember(loginUser.getMember_id(),followeeId);

        return "redirect:/my-page/follow-list";
    }

    @GetMapping("follow-list-test")
    public String followListTest(Model model){

        List<FollowInfoDetailDTO> followList= userFollowService.findFollowMember(1);

        model.addAttribute("followList", followList);

        System.out.println(followList);

        return "my-page/follow-list";
    }

}
