package com.i5.eatit.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-page/*")
public class TechProfileController {

    @GetMapping("tech-profile")
    public void techProfile() {}
}
