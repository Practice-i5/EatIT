package com.i7.eatit.home;

import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    public String home(Model model) {
        List<String> types = meetingService.findAllType();

        // MeetingDTO 목록을 가져와서 타입별로 그룹화
        List<MeetingDTO> allMeetings = meetingService.findAllMeetings();
        Map<String, List<MeetingDTO>> meetingsByType = allMeetings.stream()
                .collect(Collectors.groupingBy(MeetingDTO::getMeetingType));

        model.addAttribute("types", types);
        model.addAttribute("meetingsByType", meetingsByType);
        return "home/home"; // templates/home 디렉토리의 home.html을 가리킵니다
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
