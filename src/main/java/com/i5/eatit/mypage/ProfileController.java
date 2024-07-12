package com.i5.eatit.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/my-page/*")
@Controller
public class ProfileController {

    @GetMapping("profile")
    public void profile() {}
}
