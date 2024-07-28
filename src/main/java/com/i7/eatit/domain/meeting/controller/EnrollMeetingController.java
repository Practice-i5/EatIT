package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/enroll-meeting")
public class EnrollMeetingController {

    MeetingService meetingService;

    public EnrollMeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("enroll-meeting")
    public String enrollMeeting(Model model) {

        model.addAttribute("types", meetingService.findAllType());
        model.addAttribute("interests", meetingService.findAllInterests());
        return "enroll-meeting/enroll-meeting";
    }

    @PostMapping("enroll-meeting")
    public String createNewMeeting(MeetingDTO meeting, @RequestParam("file") MultipartFile file, @RequestParam("inputScheduledDate") String scheduledDate, @RequestParam("inputEndDate") String endDate, RedirectAttributes rttr, @RequestParam("interestsConditions") List<String> interestsConditions) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime reformScheduledTime = LocalDateTime.parse(scheduledDate, formatter);
        LocalDateTime reformEndTime = LocalDateTime.parse(endDate, formatter);
        meeting.setCreatedDate(now);
        meeting.setStatus("Open");
        meeting.setScheduledDate(Timestamp.valueOf(reformScheduledTime));
        meeting.setEndDate(Timestamp.valueOf(reformEndTime));

        meetingService.createNewMeeting(meeting);

        InsertInterestRelDTO interestsRelDTO = new InsertInterestRelDTO();
        interestsRelDTO.setInterestsConditions(interestsConditions);
        interestsRelDTO.setMeeting_id(meeting.getLastId());
        meetingService.createNewInterestsRel(interestsRelDTO);


        /*
        * 1. 이미지 파일 불러오기
        * 2. 이미지 파일 Upload Service
        * 3.
        * */
        // 파일 저장 및 DB에 경로 저장
        if (!file.isEmpty()) {
            try {
                System.out.println("사진등록 처리중");
                // 파일 저장 경로 설정
                String uploadDir = "uploads/";
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdir();
                }
                String filePath = uploadDir + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest);

                // MeetingPhotoDTO 객체 생성
                MeetingPhotoDTO meetingPhoto = new MeetingPhotoDTO();
                meetingPhoto.setMeetingId(meeting.getLastId());
                meetingPhoto.setPhotoPath(filePath);
                meetingPhoto.setPhotoName(file.getOriginalFilename());

                // 사진 정보 DB에 저장
                meetingService.uploadMeetingPhoto(meetingPhoto);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        rttr.addFlashAttribute("successMessage", "Meeting has been created");
        return "redirect:/home";
    }
}
