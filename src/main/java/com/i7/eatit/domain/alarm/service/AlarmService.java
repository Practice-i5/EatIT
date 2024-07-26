package com.i7.eatit.domain.alarm.service;

import com.i7.eatit.domain.alarm.dao.AlarmMapper;
import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlarmService {

    private final AlarmMapper alarmMapper;

    public AlarmService(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    public List<AlarmDTO> findAllAlarm(int hostMemberId) {
       return alarmMapper.findAllAlarm(hostMemberId);
    }

    public boolean checkNewAlarm(int hostMemberId){

        List<AlarmDTO> alarmList = this.findAllAlarm(hostMemberId);

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

    private int getMeetingId(int ParticipationId){
        return alarmMapper.getMeetingId(ParticipationId);
    }

    @Transactional
    public void createNewAlarm(AlarmDTO newAlarm){
        newAlarm.setMeetingId(this.getMeetingId(newAlarm.getParticipationId()));
        alarmMapper.createNewAlarm(newAlarm);
    }



    public AlarmDetailDTO findAlarmDetail(int alarmId) {
        AlarmDetailDTO dto = alarmMapper.findAlarmDetail(alarmId);
//        System.out.println(dto.toString());
        return alarmMapper.findAlarmDetail(alarmId);
    }


    public List<AlarmSimpleDTO> findSimpleAll(int hostMemberId) {
        return alarmMapper.findSimpleAll(hostMemberId);
    }
}
