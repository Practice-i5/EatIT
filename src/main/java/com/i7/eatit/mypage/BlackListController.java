package com.i7.eatit.mypage;

import com.i7.eatit.domain.relationship.dto.BlockInfoDetailDTO;
import com.i7.eatit.domain.relationship.service.UserBlockService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
        List<BlockInfoDetailDTO> blockUserList = userBlockService.findBlockedMemberById(2);
        System.out.println(blockUserList);
        model.addAttribute("blockUserList", blockUserList);


    }

    @GetMapping("black-list-test")
    public String blackListTest(){

        System.out.println(userBlockService.findBlockedMemberById(1));

        return "my-page/black-list";
    }
}
