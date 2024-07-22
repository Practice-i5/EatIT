package com.i7.eatit.domain.alarm.service;

import com.i7.eatit.domain.alarm.dao.AlarmMapper;
import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    private final AlarmMapper alarmMapper;

    public AlarmService(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    public List<AlarmDTO> findAllAlarm(int member_id) {
       return alarmMapper.findAllAlarm(member_id);
    }
}
