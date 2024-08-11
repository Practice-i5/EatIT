package com.i7.eatit.home.controller;

import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.home.service.HomeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<PreviewMeetingDTO> meetingList = homeService.findPreviewAllMeetings();
        model.addAttribute("meetingList", meetingList);
        return "home/home"; // home.html 템플릿 경로
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        return home(model);
    }

    @GetMapping("/enroll-meeting")
    public String enrollMeeting() {
        return "enroll-meeting/enroll-meeting"; // 모임 등록 페이지
    }

    @GetMapping("/search")
    public String search() {
        return "search/list"; // 모임 찾기 페이지
    }

    @GetMapping("/meetingList")
    public String meetingList() {
        return "meetingList/participatingList"; // 모임 목록 페이지
    }

    @GetMapping("/login")
    public String login() {
        return "login/loginMain"; // 로그인 페이지
    }

    @GetMapping("/signup")
    public String signup() {
        return "login/join"; // 회원가입 페이지
    }

    @GetMapping("/alarm")
    public String alarm() {
        return "alarm/alarm"; // 알람 페이지
    }

    @GetMapping("/chatGroup")
    public String chatGroup() {
        return "chatGroup/chatrooms"; // 그룹 채팅 페이지
    }
}
