package com.i7.eatit.domain.alarm.service;

import com.i7.eatit.domain.alarm.dao.AlarmMapper;
import com.i7.eatit.domain.alarm.dto.AlarmDTO;
import com.i7.eatit.domain.alarm.dto.AlarmDetailDTO;
import com.i7.eatit.domain.alarm.dto.AlarmSimpleDTO;
import com.i7.eatit.domain.alarm.dto.AlarmUpdateDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlarmService {

    private final AlarmMapper alarmMapper;

    public AlarmService(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    public List<AlarmDTO> findAllAlarm(int memberId) {
       return alarmMapper.findAllAlarm(memberId);
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


    public AlarmDTO findOneAlarm(int alarmId) {
        return alarmMapper.findOneAlarm(alarmId);
    }

    public AlarmDTO findOneAlarm(int memberId, int meetingId) {
        return alarmMapper.findOneAlarmDuo(memberId, meetingId);
    }

    private int getMeetingId(int ParticipationId){
        return alarmMapper.getMeetingId(ParticipationId);
    }
//    private int getHostParticipationId(int memberId){
//        return alarmMapper.getHostParticipationId(memberId);
//    }

    @Transactional
    public void createNewAlarm(AlarmDTO newAlarm){
        newAlarm.setParticipationId(-1);
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

    public void acceptRecruit(int alarmId) {
        alarmMapper.acceptRecruit(alarmId);
    }

    public void addParticipant(AlarmUpdateDTO alarmUpdateDTO) {
        alarmMapper.addParticipant(alarmUpdateDTO);
    }

    public void refuseRecruit(int alarmId) {
        alarmMapper.refuseRecruit(alarmId);
    }
}
