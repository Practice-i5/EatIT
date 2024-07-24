package com.i7.eatit.mypage;

import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.PhotoService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RequestMapping("/my-page/*")
@Controller
public class ProfileController {

    private PhotoService photoService;

    public ProfileController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("profile")
    public void profile(@SessionAttribute(name = "loginUser") UserInfoDTO loginUser, Model model) {
        System.out.println(loginUser);

        System.out.println(photoService.findPhotoByMemberId(loginUser.getMember_id()));

        MemberPhotoDTO photoInfo = photoService.findPhotoByMemberId(loginUser.getMember_id());
        String photoUrl = photoInfo.getPhotoPath()+photoInfo.getPhotoName();

        model.addAttribute("profileImage", photoUrl);

//        if (loginUser != null) {
//            model.addAttribute("photoImage", photoService.findPhotoByMemberId(loginUser.getMember_id()));
//
//        }
    }

    @PostMapping("profile")
    public String modifyProfile(Model model, WebRequest request) {
        //System.out.println();



        for (var it: request.getParameterMap().keySet()) {
            System.out.println(it +":" + request.getParameter(it));

        }

        //System.out.println(request.getParameter("nickName"));
        return "my-page/profile";
    }

    @GetMapping("uploadTest")
    public void uploadTest(Model model){
        //model.addAttribute("profileImage","static/img/single/018706e1412f4220ab197cce62bfab59.png");
    }

    @PostMapping("uploadTest")
    public String uploadTest(@RequestParam MultipartFile singleFile, RedirectAttributes rttr) throws IOException {

        //System.out.println("singleFile : " + singleFile);
        //System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("시도");

        String uploadedUrl = photoService.uploadMemberPhoto(singleFile, 7);
        if (uploadedUrl != null){
            rttr.addFlashAttribute("profileImage", uploadedUrl);
            rttr.addFlashAttribute("tst", "텍스트테스트");
        }
        System.out.println("결과 url");
        System.out.println(uploadedUrl);
        //rttr.addFlashAttribute("profileImage", uploadedUrl);
        return "redirect:/my-page/uploadResult";
    }

    @GetMapping("uploadResult")
    public void uploadResultPage(Model model){

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
