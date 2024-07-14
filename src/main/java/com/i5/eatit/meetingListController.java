package com.i5.eatit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meetingList/*")
public class meetingListController {

    // 로그인 메인홈으로 이동 (브랜드 이미지 클릭)
    @GetMapping("/followList")
    public String goFollowList() {

        return "meetingList/followList"; // "loginMain"을 반환하여 뷰 리졸버가 "login/loginMain.html"을 찾도록 한다.
    }
}
