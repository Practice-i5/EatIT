package com.i7.eatit.domain.alarm.dao;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<AlarmDTO> findAllAlarm(@Param("memberId") int hostMemberId);

    void createNewAlarm(AlarmDTO newAlarm);

    AlarmDetailDTO findAlarmDetail(@Param("alarmId") int alarmId);

    int getMeetingId(int participationId);

    List<AlarmSimpleDTO> findSimpleAll(int hostMemberId);
}
