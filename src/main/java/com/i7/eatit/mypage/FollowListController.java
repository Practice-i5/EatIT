package com.i7.eatit.mypage;

import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import com.i7.eatit.domain.relationship.service.UserFollowService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
            model.addAttribute("followList", followList);
        }
    }

    @GetMapping("follow-list-test")
    public String followListTest(Model model){

        List<FollowInfoDetailDTO> followList= userFollowService.findFollowMember(1);

        model.addAttribute("followList", followList);

        System.out.println(followList);

        return "my-page/follow-list";
    }

}
