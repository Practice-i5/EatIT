package com.i7.eatit.domain.alarm.controller;


import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.service.AlarmService;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/alarm")
public class AlarmPageController {

    private final AlarmService alarmService;
    private final PhotoService photoService;


    public AlarmPageController(AlarmService alarmService, PhotoService photoService) {
        this.alarmService = alarmService;
        this.photoService = photoService;
    }

    @GetMapping("alarm")
    public String alarmPage(Model model) {


        AlarmDTO testDTO = new AlarmDTO();
        testDTO.setAlarmChecked(false);
        testDTO.setAlarmDetail("ff");
        testDTO.setAlarmTime(LocalDateTime.now());
        testDTO.setAlarmStatus("ddd");
        testDTO.setMeetingId(3);
        testDTO.setMemberId(2);
        testDTO.setParticipationId(5);
        createNewAlarm(testDTO);

        //Todo : 로그인 정보 받아 와야 함

        int memberId = 4;
        List<AlarmDTO> alarmList = alarmService.findAllAlarm(memberId);
        model.addAttribute("alarmList", alarmList);



        boolean isAlarmRinging = alarmService.checkNewAlarm(memberId);

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


}
