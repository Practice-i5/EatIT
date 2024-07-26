package com.i7.eatit.domain.alarm.service;

import com.i7.eatit.domain.alarm.dao.AlarmMapper;
import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
