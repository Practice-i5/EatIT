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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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

            memberTechStackService.updateMemberTechStack(stackCodeList);
            System.out.println("성공?");
            rttr.addFlashAttribute("techModifyMessage", "성공인듯");
        } else{
            System.out.println("실패?");
            rttr.addFlashAttribute("techModifyMessage", "수정 실패");
        }

        return "redirect:/my-page/tech-profile";
    }

    @PostMapping("tech-experience-add")
    public String addTechExperience(TechExperienceDTO techExperience, @SessionAttribute("loginUser")UserInfoDTO loginUser){
        System.out.println(techExperience);
        if("on".equals(techExperience.getIsCurrent())) {
            techExperience.setIsCurrent("Y");
        } else{
            techExperience.setIsCurrent("N");
        }

        techExperience.setMemberId(loginUser.getMember_id());
        profileModifyService.addTechExperience(techExperience);

        return "redirect:/my-page/tech-profile-modify";
    }

    @PostMapping("tech-experience-modify")
    public String techExperienceModify(TechExperienceDTO techExperience, @SessionAttribute("loginUser")UserInfoDTO loginUser) {
        System.out.println(techExperience);
        if("on".equals(techExperience.getIsCurrent())) {
            techExperience.setIsCurrent("Y");
        } else{
            techExperience.setIsCurrent("N");
        }

        techExperience.setMemberId(loginUser.getMember_id());
        profileModifyService.modifyTechExperience(techExperience);

        return "redirect:/my-page/tech-profile-modify";
    }

    @PostMapping("tech-experience-delete")
    public String deleteTechExperience(@SessionAttribute("loginUser") UserInfoDTO loginUser, WebRequest request){
        //System.out.println(request.getParameter("deleteId"));
        if(request.getParameter("deleteId")==null){
            System.out.println("오류");
        } else{
            profileModifyService.deleteTechExperience(loginUser.getMember_id(), Integer.parseInt(Objects.requireNonNull(request.getParameter("deleteId"))));

        }

        return "redirect:/my-page/tech-profile-modify";
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
