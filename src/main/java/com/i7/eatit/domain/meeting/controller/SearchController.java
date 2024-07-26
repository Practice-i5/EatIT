package com.i7.eatit.domain.meeting.controller;


import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/search/*")
public class SearchController {

    private MeetingService meetingService;

    public SearchController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("search_test")
    public void search_test() {}

    @GetMapping("list")
    public String searchListPage(Model model) {

        model.addAttribute("interests", meetingService.findAllInterests());
        model.addAttribute("types", meetingService.findAllType());
        return "search/list";
    }

    @PostMapping("list")
    public String searchListPage(SearchCriteria searchCriteria, Model model) {

        System.out.println("========================프리뷰 모델==========================");
        System.out.println( meetingService.findPreviewBySearch(searchCriteria));
        System.out.println("========================개발 분야==========================");
        System.out.println(meetingService.findAllInterests());
        System.out.println("========================모임 종류==========================");
        System.out.println(meetingService.findAllType());
        model.addAttribute("previewMeetingList", meetingService.findPreviewBySearch(searchCriteria));
        model.addAttribute("interests", meetingService.findAllInterests());
        model.addAttribute("types", meetingService.findAllType());
        return "search/list";
    }

//    @PostMapping("search_test")
//    public String searchMeetingList(SearchCriteria searchCriteria, Model model) {
//
//        model.addAttribute("searchCriteria", searchCriteria);
//        model.addAttribute("successMessage", "검색에 성공했습니다.");
//
//        return "/detail/meeting-list";
//    }
}
