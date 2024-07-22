package com.i7.eatit.domain.alarm.controller;


import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.service.AlarmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alarm")
public class AlarmPageController {

    private final AlarmService alarmService;


    public AlarmPageController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @GetMapping("alarm")
    public String alarmPage(Model model) {
        FollowAlarm followAlarm = new FollowAlarm();
        JoinAlarm joinAlarm = new JoinAlarm();
        MeetingAlarm meetingAlarm = new MeetingAlarm();

        followAlarm.followname = "팔로우 한 사람 이름";
        followAlarm.profileImg = "profile.png";

        joinAlarm.joinname = "참가 신청 한 모임 이름";
        joinAlarm.joinImg = "test_image.png";

        meetingAlarm.meetingname = "모임 이름";
        meetingAlarm.meetingImg = "test_image.png";

        model.addAttribute("followname", followAlarm.followname);
        model.addAttribute("profileimg", followAlarm.profileImg);
        model.addAttribute("followMessage", FollowAlarm.followMessage);
        model.addAttribute("joinname", joinAlarm.joinname);
        model.addAttribute("joinImg", joinAlarm.joinImg);
        model.addAttribute("joinMessage", JoinAlarm.joinMessage);
        model.addAttribute("meetingname", meetingAlarm.meetingname);
        model.addAttribute("meetingImg", meetingAlarm.meetingImg);
        model.addAttribute("meetingMessage", MeetingAlarm.meetingMessage);


        //Todo : 로그인 정보 받아 와야 함
        int member_id = 1;
        List<AlarmDTO> alarmList = alarmService.findAllAlarm(member_id);
        model.addAttribute("alarmList", alarmList);

        for (AlarmDTO alarmDTO : alarmList) {
            System.out.println(alarmDTO.toString());
        }

        return "/alarm/alarm";
    }


    static class FollowAlarm{
        String followname;
        String profileImg;
        String profileLink;
        static final String followMessage = "님이 나를 팔로우 했어요!";
    }

    static class JoinAlarm {
        String joinname;
        String joinImg;
        String joinLink;
        static final String joinMessage = "모임 신청이 도착했어요!";
    }

    static class MeetingAlarm {
        String meetingname;
        String meetingImg;
        String meetingLink;
        static final String meetingMessage = "모임이 곧 시작되요!";
    }


}
