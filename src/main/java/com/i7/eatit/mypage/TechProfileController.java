package com.i7.eatit.mypage;

import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import com.i7.eatit.domain.tag.dto.MemberTechStackDetailDTO;
import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import com.i7.eatit.domain.tag.service.MemberTechStackService;
import com.i7.eatit.domain.tag.service.TechStackTypeService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public void techProfile(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model) {
        if (loginUser!=null){
            List<MemberTechStackDetailDTO> stackList = memberTechStackService.findMemberTechStack(loginUser.getMember_id());
            System.out.println(stackList);
            model.addAttribute("memberStack",stackList);
        }
    }

    @GetMapping("tech-profile-modify")
    public void techProfileModifyPage(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model) {
        List<TechStackTypeDTO> techStackList = techStackTypeService.findAllTechStack();
        model.addAttribute("techStackList", techStackList);

        if (loginUser!=null){
            List<MemberTechStackDetailDTO> stackList = memberTechStackService.findMemberTechStack(loginUser.getMember_id());
            List<Integer> stackNumberList = new ArrayList<>();
            for (MemberTechStackDetailDTO stack:stackList){
                stackNumberList.add(stack.getStackCode());
            }

            //System.out.println(stackList);
            System.out.println("멤버 스택목록");
            System.out.println(stackNumberList);
            model.addAttribute("memberStackCode", stackNumberList);

        }
    }

    @PostMapping("tech-profile-modify")
    public String techProfileModify(@SessionAttribute(name="loginUser", required = false) UserInfoDTO loginUser, WebRequest request, RedirectAttributes rttr) {

        List<MemberTechStackDTO> stackCodeList = new ArrayList<>();

        for (var it: request.getParameterMap().keySet()) {
            System.out.println(it +":" + request.getParameter(it));


            if (it.startsWith("stack-") ){
                String substr =  it.substring(6);
                if(substr.matches("\\d+")){
                    int stackCode = Integer.valueOf(substr);
                    System.out.println("숫자: "+ Integer.valueOf(substr));
                    stackCodeList.add(new MemberTechStackDTO(stackCode, loginUser.getMember_id()));
                }
            }
        }

        if(!stackCodeList.isEmpty()){
            memberTechStackService.updateMemberTechStack(stackCodeList);
            System.out.println("성공?");
            rttr.addFlashAttribute("techModifyMessage", "성공인듯");
        } else{
            System.out.println("실패?");
            rttr.addFlashAttribute("techModifyMessage", "수정 실패");
        }

        return "redirect:/my-page/tech-profile";
    }

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
    public String stackTestPage(Model model){
        List<MemberTechStackDetailDTO> stackList = memberTechStackService.findMemberTechStack(2);
        System.out.println(stackList);
        model.addAttribute("memberStack",stackList );

        return "my-page/tech-profile";
    }

    @PostMapping("member-stack-test")
    public String memberStackTest(Model model) {
        List<TechStackTypeDTO> techStackList = techStackTypeService.findAllTechStack();
        //MemberTechStackDTO memberTechStack = new MemberTechStackDTO(4, 7);
        //memberTechStackService.addMemberTechStack(memberTechStack);
        memberTechStackService.deleteMemberAllTechStack(11);
        //작성중

        return "redirect:/my-page/profile";
    }
}
