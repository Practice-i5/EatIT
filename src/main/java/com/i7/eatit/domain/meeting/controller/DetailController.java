package com.i7.eatit.domain.meeting.controller;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.service.AlarmService;
import com.i7.eatit.domain.meeting.model.common.SearchCriteria;
import com.i7.eatit.domain.meeting.model.dto.DetailMeetingDTO;
import com.i7.eatit.domain.meeting.model.dto.MeetingDTO;
import com.i7.eatit.domain.meeting.model.service.MeetingService;
import com.i7.eatit.domain.relationship.service.UserFollowService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.JoinMemberProfileService;
import com.i7.eatit.domain.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/detail/*")
public class DetailController {

    private final UserInfoService userInfoService;
    public AlarmDTO alarmDTO;
    private MeetingService meetingService;
    private AlarmService alarmService;
    private UserFollowService userFollowService;
//    private JoinMemberProfileService joinMemberService;

//    UserInfoService userInfoService;

    public DetailController(MeetingService meetingService, AlarmService alarmService, UserFollowService userFollowService,/*, JoinMemberProfileService joinMemberService*/UserInfoService userInfoService) {
        this.meetingService = meetingService;
        this.alarmService = alarmService;
//        this.joinMemberService = joinMemberService;
        this.userInfoService = userInfoService;
        this.userFollowService = userFollowService;
    }



    @GetMapping("detail")
    public String writeDoneDetail(Model model, @RequestParam("meetingId") int meetingId, @SessionAttribute("loginUser") UserInfoDTO userInfoDTO) {

        String leaderId = "임시 닉네임";

        System.out.println("==================here================\n" + meetingId + "\n=================end==================");
        System.out.println("==================here================\n" + meetingService.findPreviewById(meetingId) + "\n=================end==================");
        int temp = 81;

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
        model.addAttribute("userInfo", userInfoDTO);
        model.addAttribute("meetingImage", meetingService.findPreviewById(meetingId));
        model.addAttribute("loadMembers", meetingService.loadMembersById(meetingId));
        model.addAttribute("hostInfoDTO", userInfoService.getUserInfo(meetingService.findHostIdById(meetingId)));

        return "detail/detail";
    }
    // 모임 참가 바로참여 방식
    @PostMapping("detail")
    public String writeDetail(Model model, @ModelAttribute DetailMeetingDTO detailDTO, @SessionAttribute("loginUser") UserInfoDTO userInfoDTO) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        System.out.println("과연 결과는!!!!!!!!!\n" + detailDTO + "\n**************이게 반환되었습니다 ***************");
        model.addAttribute("meetingDTO", meetingService.findMeetingById(detailDTO.getMeetingId()));
        model.addAttribute("interests", meetingService.findInterestsById(detailDTO.getMeetingId()));
        model.addAttribute("userInfo", userInfoDTO);
//        model.addAttribute("joinMembers", joinMemberService.getUserProfileInfo(detailDTO.getMeetingId()));
        model.addAttribute("meetingImage", meetingService.findPreviewById(detailDTO.getMeetingId()));
        model.addAttribute("loadMembers", meetingService.loadMembersById(detailDTO.getMeetingId()));
        model.addAttribute("hostInfoDTO", userInfoService.getUserInfo(meetingService.findHostIdById(detailDTO.getMeetingId())));
        //        List<MeetingDTO> meetingList = meetingService.findAllMeeting();
        if (detailDTO.getDecHuman() == 1) {

            meetingService.increaseMemberReport(detailDTO.getReportedMemberId());
            model.addAttribute("decMessage", "이 유저를 신고했습니다.");

        } else if (detailDTO.getDecMeeting() == 1) {

            meetingService.increaseMeetingReport(detailDTO.getMeetingId());
            model.addAttribute("decMessage", "이 게시글을 신고했습니다.");

        } else if (detailDTO.getParticipateAcc() == 1 && meetingService.isExistAlarm(detailDTO.getMeetingId(), userInfoDTO.getMember_id()) != null) {
            if (meetingService.findMeetingById(detailDTO.getMeetingId()).getRecruitMemberNumber() < meetingService.findMeetingById(detailDTO.getMeetingId()).getRecruitmentNumber()){
                alarmDTO = new AlarmDTO();
                alarmDTO.setAlarmDetail(detailDTO.getIntroduction());
                alarmDTO.setAlarmTime(now.toLocalDateTime());
                alarmDTO.setMemberId(userInfoDTO.getMember_id());
                alarmDTO.setAlarmStatus("승인대기");
                alarmDTO.setAlarmChecked(false);
                alarmDTO.setMeetingId(detailDTO.getMeetingId());
                alarmService.createNewAlarm(alarmDTO);
                System.out.println("********************이건 alarmDTO****************\n" + alarmDTO + "****************************************");
            } else {
                model.addAttribute("decMessage", "정원이 전부 찼습니다.");
            }
        } else if (detailDTO.getParticipateFree() == 1 && meetingService.isExistPart(detailDTO.getMeetingId(), userInfoDTO.getMember_id()) != null) {
            System.out.println("heeeeeerrrrrreeeeeeee\n");
//            System.out.println("********************enrollMeeting******************\n" + );
            if (meetingService.findMeetingById(detailDTO.getMeetingId()).getRecruitMemberNumber() < meetingService.findMeetingById(detailDTO.getMeetingId()).getRecruitmentNumber()) {
                meetingService.participateGuest(detailDTO.getMeetingId(), userInfoDTO.getMember_id());
                meetingService.upCountRecruiterNum(detailDTO.getMeetingId());
                model.addAttribute("decMessage", "모임 참가 완료했습니다.");
            } else {
                model.addAttribute("decMessage", "정원이 전부 찼습니다.");
            }
        } else if (detailDTO.getDecMemberId() != 0) {
            userFollowService.insertFollowMember(userInfoDTO.getMember_id(), detailDTO.getDecMemberId()); // 누르는 사람, 대상
        }

        return "detail/detail";
    }

//    @PostMapping(value = "detail", params = {"meetingId", "memberId", "userInfoDTO", "alamDTO"})
//    public String writeDetail(Model model, @RequestParam("meetingId") int meetingId, @RequestParam("memberId") int memberId, @SessionAttribute("loginUser") UserInfoDTO userInfoDTO, AlarmDTO alarmDTO) {
//        //        List<MeetingDTO> meetingList = meetingService.findAllMeeting();
//        alarmService.createNewAlarm(alarmDTO);
//
//        String leaderId = "임시 닉네임";
//
//        model.addAttribute("meetingDTO", meetingService.findMeetingById(meetingId));
//        model.addAttribute("interests", meetingService.findInterestsById(meetingId));
//        model.addAttribute("userInfo", userInfoDTO);
//        model.addAttribute("meetingImage", meetingService.findMeetingPhotoById(meetingId));
//
//        return "detail/detail";
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
