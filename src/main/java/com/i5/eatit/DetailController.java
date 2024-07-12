package com.i5.eatit;

/*
 *   EatITController.java
 *   Author : syamcat
 *   Created : 24. 7. 11.
 **/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/detail/*")
public class DetailController {


    // /first/regist 요청이 들어오면
    // void 메소드인 경우 요청 주소가 곹 view의 이름이 된다.
    // return "/first/regist"를 작성해주는 것과 같다.

    /*
     * 1. WebRequst로 요청 파라미터 전달 받기
     * */
    @GetMapping("done-detail")
    public String writeDoneDetail(Model model) {

        String groupName = "임시 모임 이름";
        String groupLocation = "임시 모임 상세 주소";
        String leaderId = "임시 닉네임";
        String intro = "The generated Lorem Ipsum is therefore always free from repetition injected humour, or non-characteristic words etc. Susp endisse ultricies nisi vel quam suscipit";
        String theme = "임시 멘토링";
        String idDrink = "마셔요";
        String gender = "상관없음";

        // 임시 모임 일시
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a hh:mm");
        String groupDate = sdf.format(date);

        int expectPayments = 20000;
        int enterAge = 20;
        int temp = 81;

        List<String> careers = new ArrayList<>();
        careers.add("우리은행 백엔드");
        careers.add("농협은행 백엔드");
        careers.add("토스뱅크 백엔드");

        List<String> evaluates = new ArrayList<>();
        evaluates.add("시간 약속을 잘 지켜요");
        evaluates.add("질문에 대한 답변이 빨라요");
        evaluates.add("응답이 빨라요");

        List<String> categories = new ArrayList<>();
        categories.add("iOS");
        categories.add("Android");



        model.addAttribute("groupName", groupName);
        model.addAttribute("groupLocation", groupLocation);
        model.addAttribute("groupDate", groupDate);
        model.addAttribute("leaderId", leaderId);
        model.addAttribute("careers", careers);
        model.addAttribute("intro", intro);
        model.addAttribute("theme", theme);
        model.addAttribute("expectPayments", expectPayments);
        model.addAttribute("enterAge", enterAge);
        model.addAttribute("evaluates", evaluates);
        model.addAttribute("temp", temp);
        model.addAttribute("categories", categories);
        model.addAttribute("isDrink", idDrink);
        model.addAttribute("gender", gender);


        return "detail/done-detail";
    }

//    @GetMapping("detail")
//    public String writeDetail(Model model) {
//
//        return "detail/detail";
//    }
}
