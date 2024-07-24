package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.tag.dto.InsertInterestRelDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
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
        return "enroll-meeting/enroll-meeting";
    }

    @PostMapping("enroll-meeting")
    public String createNewMeeting(MeetingDTO meeting, @RequestParam("file") MultipartFile request, @RequestParam("inputScheduledDate") String scheduledDate, @RequestParam("inputEndDate") String endDate, RedirectAttributes rttr, @RequestParam("interestsConditions") List<String> interestsConditions) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        meeting.setCreatedDate(now);
        meeting.setStatus("Open");
//        meeting.setRecruitMemberNumber(0);
//        meeting.setScheduledDate(Timestamp.valueOf(scheduledDate));
//        meeting.setEndDate(Timestamp.valueOf(endDate));
        meeting.setScheduledDate(now);
        meeting.setEndDate(now);

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


        rttr.addFlashAttribute("successMessage", "Meeting has been created");
        return "redirect:/detail/meeting-list";
    }
}
