package com.i7.eatit.meeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meeting")
public class EnrollMeetingController {

    /* */
    @GetMapping
    public String enrollMeeting() {
        return "enroll-meeting/enroll-meeting.html";
    }

    @PostMapping("/enroll")
    public String addMeeting() {
        return "redirect:/main-page/home.html";
    }

    /* */

    /* */

    /* */

    /* */
}

