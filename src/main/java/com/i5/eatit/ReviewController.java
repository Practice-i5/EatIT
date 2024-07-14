package com.i5.eatit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

    @GetMapping("/memberList")
    public String reviewMain() {
        return "review/memberList";
    }
}
