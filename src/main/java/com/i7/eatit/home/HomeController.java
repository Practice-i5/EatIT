package com.i7.eatit.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home/home"; // 이것은 templates/home 디렉토리의 home.html을 가리킵니다
    }

    @GetMapping("/home")
    public String homePage() {
        return "home/home"; // 홈 페이지
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

    @GetMapping("/chat")
    public String chat() { return "chat/chat-page"; // 1:1채팅 페이지
    }

    @GetMapping("/chatGroup")
    public String chatGroup() { return "chatGroup/chat-page"; // 그룹 채팅 페이지
    }


}
