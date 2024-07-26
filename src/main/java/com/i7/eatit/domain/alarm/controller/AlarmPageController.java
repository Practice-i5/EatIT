package com.i7.eatit.domain.alarm.controller;


import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import com.i7.eatit.domain.alarm.dto.AlarmUpdateDTO;
import com.i7.eatit.domain.alarm.service.AlarmService;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alarm")
public class AlarmPageController {

    private final AlarmService alarmService;
    private final PhotoService photoService;
    private final MeetingService meetingService;



    public AlarmPageController(AlarmService alarmService, PhotoService photoService, MeetingService meetingService) {
        this.alarmService = alarmService;
        this.photoService = photoService;
        this.meetingService = meetingService;
    }

    @GetMapping("alarm")
    public String alarmPage(Model model) {

        //Todo : 로그인 정보 받아 와야 함

        int hostMemberId = 3;
        List<AlarmSimpleDTO> alarmList = alarmService.findSimpleAll(hostMemberId);
        model.addAttribute("alarmList", alarmList);



        boolean isAlarmRinging = alarmService.checkNewAlarm(hostMemberId);

        model.addAttribute("isAlarmRinging" , isAlarmRinging);

        return "alarm/alarm";
    }

    //생성 테스트
    public void createNewAlarm(AlarmDTO alarmDTO) {
        alarmService.createNewAlarm(alarmDTO);
    }


    @GetMapping(value="alarmDetail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public AlarmDetailDTO findAlarmDetail(@RequestParam int alarmId) {
        return alarmService.findAlarmDetail(alarmId);
    }


    @GetMapping(value="userImg", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public MemberPhotoDTO getUserImage(@RequestParam int userId) {
        return photoService.findPhotoByMemberId(userId);
    }

    @GetMapping(value="meetingImg", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public int getMeetingImage(@RequestParam int meetingId) {
//        return photoService.getPhotoUrlByPath()
        return 1;       //test
    }

    @GetMapping("accept")
    public String acceptJoin(@RequestParam int alarmId) {
        AlarmDTO alarmDTO = alarmService.findOneAlarm(alarmId);
        System.out.println(alarmDTO.toString());

        alarmService.acceptRecruit(alarmId);

        AlarmUpdateDTO alarmUpdateDTO  = new AlarmUpdateDTO();
        alarmUpdateDTO.setAlarmId(alarmId);
        alarmUpdateDTO.setAlarmStatus("승인");
        alarmUpdateDTO.setAlarmChecked(true);

        alarmUpdateDTO.setRole("Participant");
        alarmUpdateDTO.setMeetingId(alarmDTO.getMeetingId());
        alarmUpdateDTO.setMemberId(alarmDTO.getMemberId());

        MeetingDTO meetingDTO = meetingService.findMeetingById(alarmDTO.getMeetingId());
        alarmUpdateDTO.setMemberNum(meetingDTO.getRecruitMemberNumber() + 1);

        alarmService.addParticipant(alarmUpdateDTO);

        return "redirect:/alarm/alarm";
    }

    @GetMapping("refuse")
    public String refuseJoin(@RequestParam int alarmId) {

        alarmService.refuseRecruit(alarmId);

        return "redirect:/alarm/alarm";
    }


}
