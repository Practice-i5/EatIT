package com.i7.eatit.home.service;

import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import com.i7.eatit.home.dao.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final HomeMapper homeMapper;

    public HomeService(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    // 열려있는 참여 가능한 목록 불러오기
    public List<PreviewMeetingDTO> findPreviewAllMeetings() {
        return homeMapper.findPreviewAllMeetings();
    }
}
