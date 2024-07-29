package com.i7.eatit.mypage;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.FireBaseService;
import com.i7.eatit.domain.picture.service.PhotoService;
import com.i7.eatit.domain.user.dto.ProfileModifyDTO;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.ProfileModifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequestMapping("/my-page/*")
@Controller
public class ProfileController {

    private PhotoService photoService;
    private ProfileModifyService profileModifyService;

    public ProfileController(PhotoService photoService, ProfileModifyService profileModifyService) {
        this.photoService = photoService;
        this.profileModifyService = profileModifyService;
    }

    @GetMapping("profile")
    public void profile(@SessionAttribute(name = "loginUser") UserInfoDTO loginUser, Model model) {
        MemberPhotoDTO photoInfo = photoService.findPhotoByMemberId(loginUser.getMember_id());

        System.out.println("photoInfo:");
        System.out.println(photoInfo);

        if(photoInfo!=null){
            model.addAttribute("profileImage", photoInfo.getPhotoPath());
        }
    }

    @PostMapping("profile-img-modify" )
    public String modifyMemberImage(Model model) {

        return "redirect:/my-page/profile";
    }

    @PostMapping("profile-modify")
    public String modifyProfile(@ModelAttribute ProfileModifyDTO newProfile, @SessionAttribute("loginUser") UserInfoDTO loginUser
            , @RequestParam("imgFile") MultipartFile imgFile, RedirectAttributes rttr) {

        if (!imgFile.isEmpty()) {
            photoService.uploadMemberPhoto(imgFile, loginUser.getMember_id());
        }

        if(Objects.equals(newProfile.getGender(), "")){
            rttr.addFlashAttribute("error_gender", "성별을 선택해주세요.");
        } else{

            newProfile.setMemberId(loginUser.getMember_id());
            profileModifyService.modifyProfile(newProfile);

            loginUser.setGender(newProfile.getGender());
            loginUser.setAge(newProfile.getAge());
            loginUser.setNickname(newProfile.getNickname());

            rttr.addFlashAttribute("profileChangeMessage", "프로필을 변경했습니다.");
        }

//        for (var it: request.getParameterMap().keySet()) {
//            System.out.println(it +":" + request.getParameter(it));
//            if (request.getParameter(it) == null || request.getParameter(it).isEmpty()) {
//                rttr.addFlashAttribute("error_"+it, "해당 값은 빈 값일 수 없습니다.");
//            }
//        }

        return "redirect:/my-page/profile";
    }

    @GetMapping("reset-image")
    public String resetImage(@SessionAttribute("loginUser") UserInfoDTO loginUser, Model model) {
        photoService.setMemberDefaultImage(loginUser.getMember_id());
        return "redirect:/my-page/profile";
    }


    @GetMapping("uploadTest")
    public void uploadTest(Model model){
    }

    @PostMapping("uploadTest")
    public String uploadTest(@RequestParam MultipartFile singleFile, RedirectAttributes rttr) throws IOException {

        String uploadedUrl = photoService.uploadMemberPhoto(singleFile, 7);
        if (uploadedUrl != null){
            rttr.addFlashAttribute("profileImage", uploadedUrl);
            System.out.println("결과 url");
        }

        return "redirect:/my-page/uploadResult";
    }

    @GetMapping("uploadResult")
    public void uploadResultPage(Model model){
        System.out.println(model.getAttribute("profileImage"));
    }

}
