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
            //System.out.println("프로필 사진 url:");
            //System.out.println(photoService.getPhotoUrlByPath(photoInfo.getPhotoPath()));
            model.addAttribute("profileImage", photoInfo.getPhotoPath());
        }
    }

    @PostMapping("profile-img-modify" )
    public String modifyMemberImage(Model model) {

        return "redirect:/my-page/profile";
    }

    @PostMapping("profile-modify")
    public String modifyProfile(@ModelAttribute ProfileModifyDTO newProfile, @SessionAttribute("loginUser") UserInfoDTO loginUser
            , RedirectAttributes rttr) {

        if(Objects.equals(newProfile.getGender(), "")){
            rttr.addFlashAttribute("error_gender", "성별을 선택해주세요.");
        } else{
            System.out.println(loginUser);

            newProfile.setMemberId(loginUser.getMember_id());
            System.out.println(newProfile);
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

        //System.out.println(request.getParameter("nickName"));
        return "redirect:/my-page/profile";
    }

    @PostMapping("profile-modify-image")
    public String modifyProfileImage(@SessionAttribute("loginUser") UserInfoDTO loginUser,
            MultipartFile imgFile, RedirectAttributes rttr) throws IOException{

        if (imgFile==null) {
            rttr.addFlashAttribute("error_image", "이미지를 등록해주세요.");
        } else{
            String uploadedUrl = photoService.uploadMemberPhoto(imgFile, loginUser.getMember_id());

            if(uploadedUrl!=null){
                rttr.addFlashAttribute("profileChangeMessage", "사진을 변경했습니다.");
            } else{
                rttr.addFlashAttribute("error_image", "사진 변경에 실패했습니다.");
            }
        }

        return "redirect:/my-page/profile";
    }

    @GetMapping("uploadTest")
    public void uploadTest(Model model){
    }

    @PostMapping("uploadTest")
    public String uploadTest(@RequestParam MultipartFile singleFile, RedirectAttributes rttr) throws IOException {

        //System.out.println("singleFile : " + singleFile);
        //System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("시도");
        String gdriveUrl = "";

        String uploadedUrl = photoService.uploadMemberPhoto(singleFile, 7);
        if (uploadedUrl != null){
            //gdriveUrl = "https://drive.google.com/thumbnail?id=" + uploadedUrl + "&sz=w300";
            rttr.addFlashAttribute("profileImage", uploadedUrl);
            System.out.println("결과 url");
            //fireBaseService.deleteFirebaseBucket("memberImage/27403cca033349429e657b83eaef2727.png");
            //System.out.println(gdriveUrl);
        }

        //rttr.addFlashAttribute("profileImage", uploadedUrl);
        return "redirect:/my-page/uploadResult";
    }

    @GetMapping("uploadResult")
    public void uploadResultPage(Model model){
        //model.addAttribute("profileImage","https://drive.google.com/thumbnail?id=13G0IwZ4hbnisyGlsN4r297BZlcLLDvn1&sz=w200");

        System.out.println(model.getAttribute("profileImage"));
    }

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
