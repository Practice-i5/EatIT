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

    // 찜 목록
    @GetMapping("/meetingList/likeList")
    public String allLikeMeeting(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/likeList";
    }


    @GetMapping("/meetingList/followList")
    public String allFollowMeeting(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/followList";
    }

    @GetMapping("/meetingList/participatingList")
    public String allParticipatingMeeting(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/participatingList";
    }

    @GetMapping("/meetingList/endList")
    public String allEndMeeting(Model model) {
        List<MeetingDTO> meetingList = meetingService.findAllMeetings();
        model.addAttribute("meetingList", meetingList);

        System.out.println(meetingList);

        return "meetingList/endList";  // HTML 파일의 이름(확장자 제외)
    }

    @GetMapping("/meetingList/like2")
    public String allLike2Meeting(Model model) {
        List<MeetingDTO> meetingList = meetingService.findAllMeetings();
        model.addAttribute("meetingList", meetingList);
        return "meetingList/likeList2";  // HTML 파일의 이름(확장자 제외)
    }
}
