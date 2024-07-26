package com.i7.eatit.domain.alarm.dao;

import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import com.i7.eatit.domain.alarm.dto.AlarmUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarmMapper {
    List<AlarmDTO> findAllAlarm(@Param("memberId") int memberId);

    AlarmDTO findOneAlarm(@Param("alarmId") int alarmId);

    AlarmDTO findOneAlarmDuo(int memberId, int meetingId);

    void createNewAlarm(AlarmDTO newAlarm);

    AlarmDetailDTO findAlarmDetail(@Param("alarmId") int alarmId);

    int getMeetingId(int participationId);

    List<AlarmSimpleDTO> findSimpleAll(int hostMemberId);

    void acceptRecruit(int alarmId);

    void addParticipant(AlarmUpdateDTO alarmUpdateDTO);

    void refuseRecruit(int alarmId);
}
