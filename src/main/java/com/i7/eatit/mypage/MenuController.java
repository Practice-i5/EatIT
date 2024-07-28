package com.i7.eatit.mypage;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.PhotoService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MenuController {

    private PhotoService photoService;

    public MenuController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/my-page")
    public String myPageMenu(@SessionAttribute("loginUser") UserInfoDTO loginUser, Model model){
        System.out.println(loginUser);
        MemberPhotoDTO memberPhotoDTO = photoService.findPhotoByMemberId(loginUser.getMember_id());
        model.addAttribute("profileImage", memberPhotoDTO.getPhotoPath());

        return "my-page/menu";
    }
}
