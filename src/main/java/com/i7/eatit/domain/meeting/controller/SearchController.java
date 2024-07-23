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

//    @PostMapping("search_test")
//    public String searchMeetingList(SearchCriteria searchCriteria, Model model) {
//
//        model.addAttribute("searchCriteria", searchCriteria);
//        model.addAttribute("successMessage", "검색에 성공했습니다.");
//
//        return "/detail/meeting-list";
//    }
}
