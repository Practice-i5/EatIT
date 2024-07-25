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

    public boolean checkNewAlarm(int memberId){

        List<AlarmDTO> alarmList = this.findAllAlarm(memberId);

        int alarmCount = 0;
        for (AlarmDTO alarmDTO : alarmList) {
            if(alarmDTO.isAlarmChecked()){
                alarmCount++;
            }
        }
//        System.out.println("안읽은 알람 갯수 : " + alarmCount);

        // 하나라도 있으면 true
        return alarmCount > 0;
//        return false;
    }

    public void createNewAlarm(AlarmDTO newAlarm){
        alarmMapper.createNewAlarm(newAlarm);
    }


    public List<AlarmDTO> findAlarmDatail(int alarmId) {
        return null;
    }
}
