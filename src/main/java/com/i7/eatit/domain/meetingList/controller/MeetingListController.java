package com.i7.eatit.domain.meetingList.controller;


import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("meetingList/*")
public class MeetingListController {

    private MeetingService meetingService;

    public MeetingListController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }


    // 진행중인 모임 목록
    @GetMapping("/meetingList/participatingList")
    public String ParticipatingMeeting(@SessionAttribute("loginUser") UserInfoDTO userInfoDTO, Model model) {

        System.out.println(userInfoDTO.getMember_id());

        List<PreviewMeetingDTO> meetingList = meetingService.findPreviewByMemberIdOpen(userInfoDTO.getMember_id());

        model.addAttribute("meetingList", meetingList);

        return "meetingList/participatingList";
    }


    // 종료한 모임 목록
    @GetMapping("/meetingList/endList")
    public String EndMeeting(@SessionAttribute("loginUser") UserInfoDTO userInfoDTO, Model model) {

        System.out.println(userInfoDTO.getMember_id());

        List<PreviewMeetingDTO> meetingList = meetingService.findPreviewByMemberIdClosed(userInfoDTO.getMember_id());

        model.addAttribute("meetingList", meetingList);

        System.out.println(meetingList);

        return "meetingList/endList";  // HTML 파일의 이름(확장자 제외)
    }





    // 팔로잉한 모임 목록
    @GetMapping("/meetingList/followList")
    public String FollowMeeting(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/followList";
    }


    // 찜한 모임 목록
    @GetMapping("/meetingList/likeList")
    public String LikeMeetingList(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "meetingList/likeList";
    }


    // like2 연습용 url
    @GetMapping("/meetingList/like2")
    public String Like2Meeting(Model model) {
        List<MeetingDTO> meetingList = meetingService.findAllMeetings();
        model.addAttribute("meetingList", meetingList);
        return "meetingList/likeList2";  // HTML 파일의 이름(확장자 제외)
    }

}
