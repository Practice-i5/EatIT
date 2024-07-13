package com.i5.eatit.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/my-page/*")
@Controller
public class ProfileController {

    @GetMapping("profile")
    public void profile() {}

    @GetMapping("profile/test")
    public String profileTest(Model model){
        model.addAttribute("profileImage", "/img/my-page/파르토.webp");
        model.addAttribute("nickName", "팡요");
        model.addAttribute("gender", "male");
        model.addAttribute("age", 27);
        model.addAttribute("introduce", "판교에 서식하는 자바 백엔드 개발자, 디저트 카페 찾는걸 좋아함.");

        return "my-page/profile";
    }
}
