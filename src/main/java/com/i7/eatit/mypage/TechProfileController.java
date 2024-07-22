package com.i7.eatit.mypage;

import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import com.i7.eatit.domain.tag.service.MemberTechStackService;
import com.i7.eatit.domain.tag.service.TechStackTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/my-page/*")
public class TechProfileController {

    private final MemberTechStackService memberTechStackService;
    TechStackTypeService techStackTypeService;

    public TechProfileController(TechStackTypeService techStackTypeService, MemberTechStackService memberTechStackService) {
        this.techStackTypeService = techStackTypeService;
        this.memberTechStackService = memberTechStackService;
    }

    @GetMapping("tech-profile")
    public void techProfile() {}

    @GetMapping("tech-profile-modify")
    public void techProfileModify() {}

    @GetMapping("tech-profile/test")
    public String getTechStack(Model model) {
        List<TechStackTypeDTO> techStackList = techStackTypeService.findAllTechStack();
//        techStackList.add(new TechStackTypeDTO(1,  "backend"));
//        techStackList.add(new TechStackTypeDTO(2,  "frontend"));
//        techStackList.add(new TechStackTypeDTO(3,  "game client"));
//        techStackList.add(new TechStackTypeDTO(4,  "project management"));
//        techStackList.add(new TechStackTypeDTO(5,  "ai"));

        model.addAttribute("techStackList", techStackList);

        return "my-page/tech-profile-modify";
    }

    @GetMapping("member-stack-test")
    public String stackTestPage(){
        return "my-page/stacktest";
    }

    @PostMapping("member-stack-test")
    public String memberStackTest(Model model) {
        List<TechStackTypeDTO> techStackList = techStackTypeService.findAllTechStack();
        MemberTechStackDTO memberTechStack = new MemberTechStackDTO(4, 7);
        memberTechStackService.addMemberTechStack(memberTechStack);
        memberTechStackService.deleteMemberAllTechStack(11);
        //작성중

        return "redirect:/my-page/profile";
    }
}
