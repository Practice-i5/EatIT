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
@RequestMapping("/alarm/*")
public class AlarmPageController {

    private final AlarmService alarmService;
    private final PhotoService photoService;
    private final MeetingService meetingService;


    public interface STATUS {
        String ACCEPT = "승인";
        String REFUSE = "거절";
        String WAITING = "승인대기";
    }


    public AlarmPageController(AlarmService alarmService, PhotoService photoService, MeetingService meetingService) {
        this.alarmService = alarmService;
        this.photoService = photoService;
        this.meetingService = meetingService;
    }

    @GetMapping("/alarm")
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
//        String print = "";
//        for (AlarmSimpleDTO alarm : alarmList) {
//            print += alarm.getMeetingName() + " , ";
//        }
//        System.out.println(print);

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

    //알람 배지용 송신
    @GetMapping(value = "alarmCheck", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String alarmCheck(@SessionAttribute(value = "loginUser", required = false) UserInfoDTO loginUser) {
        if (loginUser == null) {
            return String.valueOf(false);
        }
        int hostMemberId = loginUser.getMember_id();
        boolean isAlarmRinging = alarmService.checkNewAlarm(hostMemberId);
        return String.valueOf(isAlarmRinging);
    }

    //생성 테스트
    public void createNewAlarm(AlarmDTO alarmDTO) {
        alarmService.createNewAlarm(alarmDTO);
    }

    //알람 모달에 디테일 표시하기 위한 json 송신
    @GetMapping(value="alarmDetail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public AlarmDetailDTO findAlarmDetail(@RequestParam int alarmId) {
        AlarmDetailDTO alarmDetailDTO = alarmService.findAlarmDetail(alarmId);
        System.out.println(alarmDetailDTO.toString());
        return alarmDetailDTO;
    }

    //유저 이미지용 url 송신
    @GetMapping(value="userImg", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public MemberPhotoDTO getUserImage(@RequestParam int userId) {
        return photoService.findPhotoByMemberId(userId);
    }

    //미팅 단일 이미지용 url 송신
    @GetMapping(value="meetingImg", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getMeetingImage(@RequestParam int meetingId) {
        System.out.println("meeting id : " + meetingId);
        MeetingPhotoDTO photoDTO = photoService.findPhotoByMeetingId(meetingId);
        System.out.println("photoPath : "+ photoDTO.getPhotoPath());
        //System.out.println("url : " + photoService.getPhotoUrlByPath(photoDTO.getPhotoPath()));

        return photoDTO.getPhotoPath();
        //return photoService.getPhotoUrlByPath(photoDTO.getPhotoPath());
    }

    //미팅 이미지 url 리스트  송신
    @GetMapping(value="meetingImgs", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> getMeetingImages(@RequestParam List<Integer> meetingIdList) {
        List<String> images = new ArrayList<>();
        for (Integer meetingId : meetingIdList) {
//            System.out.println("meeting id : " + meetingId);
            MeetingPhotoDTO photoDTO = photoService.findPhotoByMeetingId(meetingId);
//            System.out.println("photoPath : "+ photoDTO.getPhotoPath());
            String url = photoDTO.getPhotoPath();
            //String url = photoService.getPhotoUrlByPath(photoDTO.getPhotoPath());
//            System.out.println("url : " + url);
            images.add(url);
        }
        return images;
    }


    //수락
    @GetMapping("accept")
    public String acceptJoin(@RequestParam int alarmId) {
        AlarmDTO alarmDTO = alarmService.findOneAlarm(alarmId);
//        System.out.println(alarmDTO.toString());

        //이미 처리 되어있으면 수정 불가
        if (!alarmDTO.getAlarmStatus().equals(STATUS.WAITING)){
            return "redirect:/alarm/alarm";
        }

        //알람 테이블 승인 처리
        alarmService.acceptRecruit(alarmId);

        AlarmUpdateDTO alarmUpdateDTO  = new AlarmUpdateDTO();
        alarmUpdateDTO.setAlarmId(alarmId);
        alarmUpdateDTO.setAlarmStatus(STATUS.ACCEPT);
        alarmUpdateDTO.setAlarmChecked(true);

        alarmUpdateDTO.setRole("Participant");
        alarmUpdateDTO.setMeetingId(alarmDTO.getMeetingId());
        alarmUpdateDTO.setMemberId(alarmDTO.getMemberId());

        MeetingDTO meetingDTO = meetingService.findMeetingById(alarmDTO.getMeetingId());
        alarmUpdateDTO.setMemberNum(meetingDTO.getRecruitMemberNumber() + 1);

        //참여 테이블에 추가
        alarmService.addParticipant(alarmUpdateDTO);

        //미팅 테이블에 해당 모임 인구수 +1
        meetingService.upCountRecruiterNum(alarmDTO.getMeetingId());

        return "redirect:/alarm/alarm";
    }

    //거절
    @GetMapping("refuse")
    public String refuseJoin(@RequestParam int alarmId) {
        AlarmDTO alarmDTO = alarmService.findOneAlarm(alarmId);

        //이미 처리 되어있으면 수정 불가
        if (!alarmDTO.getAlarmStatus().equals(STATUS.WAITING)){
            return "redirect:/alarm/alarm";
        }

        //알람 테이블 거절 처리
        alarmService.refuseRecruit(alarmId);

        return "redirect:/alarm/alarm";
    }


}
