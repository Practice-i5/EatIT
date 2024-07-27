package com.i7.eatit.domain.alarm.controller;


import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import com.i7.eatit.domain.alarm.dto.AlarmUpdateDTO;
import com.i7.eatit.domain.alarm.service.AlarmService;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import com.i7.eatit.domain.picture.service.PhotoService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String alarmPage(Model model, @SessionAttribute(value = "loginUser", required = false) UserInfoDTO loginUser) {

        //로그인된 MemberId 가져오기
        int hostMemberId ;
//        hostMemberId =3;    //test
        try {
            hostMemberId = loginUser.getMember_id();
        }catch (NullPointerException e){
            return "redirect:/login";
        }


        //신청 알람 리스트
        List<AlarmSimpleDTO> alarmList = alarmService.findSimpleAll(hostMemberId);
        model.addAttribute("alarmList", alarmList);

        //미팅 이미지 로딩용 리스트
        List<Integer> meetingIdList = new ArrayList<>();
        for (AlarmSimpleDTO alarmSimpleDTO : alarmList) {
            meetingIdList.add(alarmSimpleDTO.getMeetingId());
        }
        model.addAttribute("meetingIdList", meetingIdList);

        //알람 배지
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
    public String getMeetingImage(@RequestParam int meetingId) {
        System.out.println("meeting id : " + meetingId);
        MeetingPhotoDTO photoDTO = photoService.findPhotoByMeetingId(meetingId);
        System.out.println("photoPath : "+ photoDTO.getPhotoPath());
        System.out.println("url : " + photoService.getPhotoUrlByPath(photoDTO.getPhotoPath()));

        return photoService.getPhotoUrlByPath(photoDTO.getPhotoPath());
    }

    @GetMapping(value="meetingImgs", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> getMeetingImages(@RequestParam List<Integer> meetingIdList) {
        List<String> images = new ArrayList<>();
        for (Integer meetingId : meetingIdList) {
            System.out.println("meeting id : " + meetingId);
            MeetingPhotoDTO photoDTO = photoService.findPhotoByMeetingId(meetingId);
            System.out.println("photoPath : "+ photoDTO.getPhotoPath());
            String url = photoService.getPhotoUrlByPath(photoDTO.getPhotoPath());
            System.out.println("url : " + url);
            images.add(url);
        }
        return images;
    }

    @GetMapping("accept")
    public String acceptJoin(@RequestParam int alarmId) {
        AlarmDTO alarmDTO = alarmService.findOneAlarm(alarmId);
//        System.out.println(alarmDTO.toString());

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
