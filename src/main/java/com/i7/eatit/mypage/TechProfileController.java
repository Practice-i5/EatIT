package com.i7.eatit.mypage;

import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import com.i7.eatit.domain.tag.dto.MemberTechStackDetailDTO;
import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import com.i7.eatit.domain.tag.service.MemberTechStackService;
import com.i7.eatit.domain.tag.service.TechStackTypeService;
import com.i7.eatit.domain.user.dto.TechExperienceDTO;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.ProfileModifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/my-page/*")
public class TechProfileController {

    private final MemberTechStackService memberTechStackService;
    private TechStackTypeService techStackTypeService;
    private ProfileModifyService profileModifyService;


    public TechProfileController(MemberTechStackService memberTechStackService, TechStackTypeService techStackTypeService, ProfileModifyService profileModifyService) {
        this.memberTechStackService = memberTechStackService;
        this.techStackTypeService = techStackTypeService;
        this.profileModifyService = profileModifyService;
    }

    @GetMapping("tech-profile")
    public void techProfile(@SessionAttribute(name = "loginUser", required = false) UserInfoDTO loginUser, Model model) {
        if (loginUser!=null){
            List<MemberTechStackDetailDTO> stackList = memberTechStackService.findMemberTechStack(loginUser.getMember_id());
            System.out.println(stackList);
            model.addAttribute("memberStack",stackList);
            List<TechExperienceDTO> techExperienceList = profileModifyService.findMemberTechExperience(loginUser.getMember_id());
            model.addAttribute("techExperienceList", techExperienceList);

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

            model.addAttribute("memberStackCode", stackNumberList);

            List<TechExperienceDTO> techExperienceList = profileModifyService.findMemberTechExperience(loginUser.getMember_id());
            model.addAttribute("techExperienceList", techExperienceList);

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
            System.out.println("stackCodeList 사이즈:" + stackCodeList.size());
            if(stackCodeList.size()<=5){
                memberTechStackService.updateMemberTechStack(stackCodeList);
            } else{
                rttr.addFlashAttribute("stack_error", "5개까지 선택가능합니다.");
                return "redirect:/my-page/tech-profile-modify";
            }
            System.out.println("성공?");
        } else{
            rttr.addFlashAttribute("stack_error", "스택을 선택해주세요.");
            System.out.println("실패?");
            return "redirect:/my-page/tech-profile-modify";
        }

        return "redirect:/my-page/tech-profile";
    }
    

    @PostMapping("tech-experience-modify")
    public String techExperienceModify(TechExperienceDTO techExperience, RedirectAttributes rttr, @SessionAttribute("loginUser")UserInfoDTO loginUser) {
        System.out.println(techExperience);
        if("on".equals(techExperience.getIsCurrent())) {
            techExperience.setIsCurrent("Y");
        } else{
            techExperience.setIsCurrent("N");
        }

        techExperience.setMemberId(loginUser.getMember_id());
        
        if(techExperience.getExperienceId()!=null){
            profileModifyService.modifyTechExperience(techExperience);
        } else{
            List<TechExperienceDTO> techExperienceList = profileModifyService.findMemberTechExperience(loginUser.getMember_id());
            if(techExperienceList.size()>5){
                rttr.addFlashAttribute("experience_error", "10개까지 선택가능합니다.");
            } else{
                profileModifyService.addTechExperience(techExperience);
            }
        }

        return "redirect:/my-page/tech-profile-modify";
    }

    @PostMapping("tech-experience-delete")
    public String deleteTechExperience(@SessionAttribute("loginUser") UserInfoDTO loginUser, WebRequest request){
        if(request.getParameter("deleteId")==null){
            System.out.println("오류");
        } else{
            profileModifyService.deleteTechExperience(loginUser.getMember_id(), Integer.parseInt(Objects.requireNonNull(request.getParameter("deleteId"))));
        }

        return "redirect:/my-page/tech-profile-modify";
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
        memberTechStackService.deleteMemberAllTechStack(11);

        return "redirect:/my-page/profile";
    }
}
