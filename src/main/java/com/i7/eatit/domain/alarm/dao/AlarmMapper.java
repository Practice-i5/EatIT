package com.i7.eatit.domain.alarm.dao;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<AlarmDTO> findAllAlarm(@Param("memberId") int member_id);

    void createNewAlarm(AlarmDTO newAlarm);

    AlarmDetailDTO findAlarmDetail(@Param("alarmId") int alarmId);

}
