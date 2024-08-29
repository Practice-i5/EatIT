package com.i7.eatit.domain.meetingList.controller;

import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("meetingList/*")
public class MeetingListController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingListController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }


    // 진행중인 모임 목록
    @GetMapping("/participatingList")
    public String participatingMeeting(@SessionAttribute("loginUser") UserInfoDTO userInfoDTO,
        Model model) {
        int memberId = userInfoDTO.getMember_id();
        List<PreviewMeetingDTO> meetingList = meetingService.findPreviewByMemberIdOpen(memberId);
        model.addAttribute("meetingList", meetingList);
        return "meetingList/participatingList";
    }

    // 종료한 모임 목록
    @GetMapping("/endList")
    public String endMeeting(@SessionAttribute("loginUser") UserInfoDTO userInfoDTO, Model model) {
        List<PreviewMeetingDTO> meetingList = meetingService.findPreviewByMemberIdClosed(1);
        model.addAttribute("meetingList", meetingList);
        return "meetingList/endList";  // HTML 파일의 이름(확장자 제외)
    }
}