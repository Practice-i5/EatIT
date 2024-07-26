package com.i7.eatit.domain.review.controller;


import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

    // 받아와야 하는 값 - 미팅 시간, 미팅 제목, 전체 인원수, 게스트 인원수,
    // 참가자(호스트, 게스트), 호스트 이름, 게스트 이름평가항목

    private MeetingService meetingService;

    public ReviewController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/reviewMain")
    public void reviewPage(Model model) {}
}
