package com.i5.eatit.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-page/*")
public class BlackListController {

    @GetMapping("black-list")
    public void blackList() {}
}
