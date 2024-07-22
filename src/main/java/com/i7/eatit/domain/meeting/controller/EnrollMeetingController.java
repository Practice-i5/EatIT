package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/enroll-meeting")
public class EnrollMeetingController {

    MeetingService meetingService;

    public EnrollMeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("enroll-meeting")
    public String enrollMeeting(Model model) {
        return "enroll-meeting";
    }

    @PostMapping("enroll-meeting")
    public String createNewMeeting(MeetingDTO meeting, RedirectAttributes rttr) {

        meetingService.createNewMeeting(meeting);

        rttr.addFlashAttribute("successMessage", "Meeting has been created");
        return "redirect:/detail/done-detail";
    }
}
