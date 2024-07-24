package com.i7.eatit.domain.alarm.dao;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<AlarmDTO> findAllAlarm(@Param("memberId") int member_id);
}
