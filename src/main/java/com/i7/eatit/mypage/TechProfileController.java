package com.i7.eatit.mypage;

import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import com.i7.eatit.domain.tag.service.TechStackTypeService;
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

    TechStackTypeService techStackTypeService;

    public TechProfileController(TechStackTypeService techStackTypeService) {
        this.techStackTypeService = techStackTypeService;
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
}
