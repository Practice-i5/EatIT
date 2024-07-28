package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.JoinMemberProfileMapper;
import com.i7.eatit.domain.user.dto.JoinMemberProfileDTO;
import com.i7.eatit.domain.user.dto.RevieweeProfileDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinMemberProfileService {
    /*
        - 프로필
        회원 한명의
        사진, 내 기술스택, 회원번호, 닉네임
     */

    private JoinMemberProfileMapper joinMemberProfileMapper;

    public JoinMemberProfileService(JoinMemberProfileMapper joinMemberProfileMapper) {
        this.joinMemberProfileMapper = joinMemberProfileMapper;
    }

    // 미팅 아이디를 기준으로 유저의 정보를 받아서 리스트로 출력
    public List<JoinMemberProfileDTO> getUserProfileInfo(int meeting_id) {

        // 1. 미팅 아이디로 유저 조회해서 출력하기
        List<JoinMemberProfileDTO> meetingList = joinMemberProfileMapper.findJoinUser(meeting_id);

        return meetingList;
    }

    // 리뷰를 위한 정보 받기 ( 닉네임, 대표사진, memberId)
    public List<RevieweeProfileDTO> getRevieweeProfileInfo(int meetingId) {

        // 1. 미팅 아이디로 유저 조회해서 출력하기
        List<RevieweeProfileDTO> meetingList = joinMemberProfileMapper.findJoinUserModal(meetingId);

        return meetingList;
    }
}
