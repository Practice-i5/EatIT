package com.i5.eatit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enroll")
public class EnrollMeetingController {

    /* */
    @GetMapping
    public String enrollMeeting() {
        return "enroll-meeting/enroll-meeting.html";
    }

    /* */

    /* */

    /* */

    /* */
}
