package com.i5.eatit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

    @GetMapping("/memberList")
    public String goReview() {
        return "review/memberList";
    }

    // 모임 정보 받아오기(시간, 모임제목, 참가자(호스트, 게스트)

}
