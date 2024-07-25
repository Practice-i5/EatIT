package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/detail/*")
public class DetailController {

    MeetingService meetingService;
//    UserInfoService userInfoService;

    public DetailController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

//    @GetMapping("detail")
//    public String writeDoneDetail(Model model) {
//
////        List<MeetingDTO> meetingList = meetingService.findAllMeeting();
//
//        String groupName = "임시 모임 이름";
//        String groupLocation = "임시 모임 상세 주소";
//        String leaderId = "임시 닉네임";
//        String intro = "The generated Lorem Ipsum is therefore always free from repetition injected humour, or non-characteristic words etc. Susp endisse ultricies nisi vel quam suscipit";
//        String theme = "임시 멘토링";
//        String idDrink = "마셔요";
//        String gender = "상관없음";
//        String buttonStr = "바로신청";
//
//
//        // 임시 모임 일시
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a hh:mm");
//        String groupDate = sdf.format(date);
//
//        int expectPayments = 20000;
//        int enterAge = 20;
//        int temp = 81;
//
//        List<String> careers = new ArrayList<>();
//        careers.add("우리은행 백엔드");
//        careers.add("농협은행 백엔드");
//        careers.add("토스뱅크 백엔드");
//
//        List<String> evaluates = new ArrayList<>();
//        evaluates.add("시간 약속을 잘 지켜요");
//        evaluates.add("질문에 대한 답변이 빨라요");
//        evaluates.add("모임종료");
//
//        List<String> categories = new ArrayList<>();
//        categories.add("iOS");
//        categories.add("Android");
//
//
//
//        model.addAttribute("groupName", groupName);
//        model.addAttribute("groupLocation", groupLocation);
//        model.addAttribute("groupDate", groupDate);
//        model.addAttribute("leaderId", leaderId);
//        model.addAttribute("careers", careers);
//        model.addAttribute("intro", intro);
//        model.addAttribute("theme", theme);
//        model.addAttribute("expectPayments", expectPayments);
//        model.addAttribute("enterAge", enterAge);
//        model.addAttribute("evaluates", evaluates);
//        model.addAttribute("temp", temp);
//        model.addAttribute("categories", categories);
//        model.addAttribute("isDrink", idDrink);
//        model.addAttribute("gender", gender);
//        model.addAttribute("buttonStr", buttonStr);
//
//
//        return "detail/detail";
//    }

//    @PostMapping("detail")
    @GetMapping("detail")
    public String writeDoneDetail(Model model, @RequestParam("meetingId") int meetingId) {

//        List<MeetingDTO> meetingList = meetingService.findAllMeeting();
        String leaderId = "임시 닉네임";

        // 임시 모임 일시
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a hh:mm");
//        String groupDate = sdf.format(date);

        int temp = 81;
//        model.addAttribute("careers", userinfoservice....(member_id));
//
//        model.addAttribute("evaluates", userInfoService....(member_id));

        List<String> careers = new ArrayList<>();
        careers.add("우리은행 백엔드");
        careers.add("농협은행 백엔드");
        careers.add("토스뱅크 백엔드");
        List<String> evaluates = new ArrayList<>();
        evaluates.add("시간 약속을 잘 지켜요");
        evaluates.add("질문에 대한 답변이 빨라요");
        evaluates.add("모임종료");


        model.addAttribute("careers", careers);
        model.addAttribute("evaluates", evaluates);
        model.addAttribute("temp", temp);
        model.addAttribute("meetingDTO", meetingService.findMeetingById(meetingId));
        model.addAttribute("interests", meetingService.findInterestsById(meetingId));

        return "detail/detail";
    }

//    @PostMapping("detail")
//    public String writeDetail(Model model, MeetingDTO meetingDTO) {
//
//
//    }

    @GetMapping(value = "meeting-list")
    public String allMeetings(Model model) {

        model.addAttribute("meetingList", meetingService.findAllMeetings());
        return "detail/meeting-list";
    }

    @PostMapping(value = "meeting-list")
    public String searchedMeetings(SearchCriteria searchCriteria, Model model) {    // @RequestBody 쓰면 JSON으로 묶어서 보내야 charset error가 발생 안 한다.
        System.out.println(searchCriteria);
        model.addAttribute("meetingList", meetingService.searchMeetings(searchCriteria));
        return "detail/meeting-list";
    }
}
