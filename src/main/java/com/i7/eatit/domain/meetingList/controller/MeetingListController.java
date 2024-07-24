package com.i7.eatit.domain.meetingList.controller;


import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("meetingList/*")
public class MeetingListController {

    private MeetingService meetingService;

    public MeetingListController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetingList/likeList")
    public String allMeetings(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/like";
    }

    @GetMapping("/meetingList/likeList2")
    public String getAllMeetings(Model model) {
        List<MeetingDTO> meetingList = meetingService.findAllMeetings();
        model.addAttribute("meetingList", meetingList);
        return "meetingList/like2";  // HTML 파일의 이름(확장자 제외)
    }
}
