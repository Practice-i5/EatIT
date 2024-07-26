package com.i7.eatit.domain.review.controller;


import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;
import com.i7.eatit.domain.user.service.JoinMemberProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

    // 받아와야 하는 값 - 미팅 시간, 미팅 제목, 전체 인원수, 게스트 인원수,
    // 참가자(호스트, 게스트), 호스트 이름, 게스트 이름평가항목

    // 미팅 리스트 데이터 베이스에서 불러와야 할 것들
    //	-모임 날짜, 모임 타이틀, 모임원 이름, 모임원 수, 호스트 이름,

    //구현해야 할 기능
    //	1. 평가하기 값 db에 저장
    //	2. 확인 버튼 누르면 상세창으로 돌아가기

    private MeetingService meetingService;
    private JoinMemberProfileService joinMemberProfileService;

    public ReviewController(MeetingService meetingService, JoinMemberProfileService joinMemberProfileService) {
        this.meetingService = meetingService;
        this.joinMemberProfileService = joinMemberProfileService;
    }


    // 1. 디테일 창에서 리뷰 페이지로 넘어간다.
    // 2. 리뷰페이지에 접속 시 바로 참가자와 모임의 정보를 가져와서 타임리프에 적용한다.
    @GetMapping("/reviewPage")
    public String getJoinMemberInfo(Model model, @RequestParam("meetingId") int meetingId) {

        // 타이틀, 시간, 참가자 수 (나열)
        MeetingDTO meetingInfo = meetingService.findMeetingById(meetingId);

        // 참가자 - 닉네임, 사진 ( for each)
        List<JoinMemberProfileDTO> memberList = joinMemberProfileService.getUserProfileInfo(meetingId);

        // 타임리프에 적용
        model.addAttribute("meetingInfo", meetingInfo);
        model.addAttribute("memberList", memberList);
        
        return "redirect:/review/ReviewPage";
    }


}
