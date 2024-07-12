package com.i5.eatit.Alarm;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alarm/*")
public class AlarmPageController {

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


        return "/alarm/alarm";
    }


    static class FollowAlarm{
        String followname;
        String profileImg;
        static final String followMessage = "님이 나를 팔로우 했어요!";
    }

    static class JoinAlarm {
        String joinname;
        String joinImg;
        static final String joinMessage = "모임 신청이 도착했어요!";
    }

    static class MeetingAlarm {
        String meetingname;
        String meetingImg;
        static final String meetingMessage = "모임이 곧 시작되요!";
    }

}
