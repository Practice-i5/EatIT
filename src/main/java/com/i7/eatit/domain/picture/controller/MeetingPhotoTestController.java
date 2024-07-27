package com.i7.eatit.domain.picture.controller;

import com.i7.eatit.domain.picture.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MeetingPhotoTestController {

    private PhotoService photoService;

    public MeetingPhotoTestController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/uploadMeetingPhoto")
    public String testMeetingPhoto() {
        return "/MeetingPhotoTestUpload";
    }

    @PostMapping("/uploadMeetingPhoto")
    public String testSendPhoto(@RequestParam int meetingId, @RequestParam MultipartFile meetingPhoto, RedirectAttributes rttr)
    {
        String path = photoService.uploadMeetingPhoto(meetingPhoto, meetingId);

        rttr.addFlashAttribute("resultImageUrl", path);
        rttr.addFlashAttribute("meetingId", meetingId);

        return "redirect:/uploadMeetingPhoto";
    }
}
