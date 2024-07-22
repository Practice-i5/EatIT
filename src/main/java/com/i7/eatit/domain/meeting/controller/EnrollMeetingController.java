package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;

@Controller
@RequestMapping("/enroll-meeting")
public class EnrollMeetingController {

    MeetingService meetingService;

    public EnrollMeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("enroll-meeting")
    public String enrollMeeting(Model model) {
        return "enroll-meeting/enroll-meeting";
    }

    @PostMapping("enroll-meeting")
    public String createNewMeeting(MeetingDTO meeting, @RequestParam("file") MultipartHttpServletRequest request, RedirectAttributes rttr) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        meeting.setCreatedDate(now);
        meeting.setStatus("Open");

        meetingService.createNewMeeting(meeting);

        /*
        * 1. 이미지 파일 불러오기
        * 2. 이미지 파일 Upload Service
        * 3.
        * */
        Iterator<String> fileNames = request.getFileNames();
        String uploadedFileName = null;
        MultipartFile uploadFile = null;

        if (fileNames.hasNext()) {
            uploadedFileName = fileNames.next();
            uploadFile = request.getFile(uploadedFileName);
        }

        rttr.addFlashAttribute("successMessage", "Meeting has been created");
        return "redirect:/detail/meeting-list";
    }
}
