package com.i7.eatit.mypage;

import com.i7.eatit.common.DTO.techStackDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/my-page/*")
public class TechProfileController {

    @GetMapping("tech-profile")
    public void techProfile() {}

    @GetMapping("tech-profile-modify")
    public void techProfileModify() {}

    @GetMapping("tech-profile/test")
    public String getTechStack(Model model) {
        List<techStackDTO> techStackList = new ArrayList<>();
        techStackList.add(new techStackDTO(1, "백엔드", "backend"));
        techStackList.add(new techStackDTO(2, "프론트엔드", "frontend"));
        techStackList.add(new techStackDTO(3, "게임 클라이언트", "game client"));
        techStackList.add(new techStackDTO(4, "기획", "project management"));
        techStackList.add(new techStackDTO(5, "인공지능", "ai"));

        model.addAttribute("techStackList", techStackList);

        return "/my-page/tech-profile-modify";
    }
}
