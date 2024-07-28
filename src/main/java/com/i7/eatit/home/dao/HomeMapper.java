package com.i7.eatit.home.dao;

import com.i7.eatit.domain.meeting.model.dto.PreviewMeetingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {

    List<PreviewMeetingDTO> findPreviewAllMeetings();

}
