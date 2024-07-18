package com.i7.eatit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ReviewController {

    /*
    페이지 이동
     */
    
    // 리뷰하러 가는 페이지
    @GetMapping("/review/reviewMain")
    public void goReview() {
    }

    // 상세 페이지로 이동
    @GetMapping("/index")
    public void goIndex() {
    }

    /*
    모임 정보 가져오기 (시간, 모임제목, 참가자(호스트, 게스트)
     */

    @GetMapping()


    /*
    리뷰 등록하기 - 체크한 체크박스를 db에 저장
     */
    
    
    
    // 모임 정보 받아오기(시간, 모임제목, 참가자(호스트, 게스트)
    @PostMapping("/review/regist")
    public void goRegister() {
        
    }
}
