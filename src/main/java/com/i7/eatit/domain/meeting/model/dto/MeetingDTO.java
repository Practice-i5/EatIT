package com.i7.eatit.domain.meeting.model.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class MeetingDTO {

    private int meetingId;          // 모임 id
    private String title;           // 모임 제목
    private String locationName;    // 모임 장소명
    private double locationLatitude;// 모임 위도
    private double locationLongitude;// 모임 경도
    private String introduction;        // 모임 설명
    private String paymentMethod;       // 지불 방식
    private String meetingType;         // 모임 종류
    private Timestamp scheduledDate;    // 모임 일시
    private Time exitRestrictionTime;   // 퇴장 가능시간
    private int recruitMemberNumber;    // 참가중인 인원
    private int recruitmentNumber;      // 모집 인원
    private String gender;              // 가능 성별
    private String eligibleAge;         // 가능 연령대
    private Timestamp createdDate;      // 생성 일자
    private String participationMethod; // 참여 방식
    private String status;              // 모임 상태
    private Timestamp endDate;          // 종료 일시
    private int hostMemberId;           // 호스트 멤버 id
    private int lastId;                 // 이건 이전 auto_i

    public MeetingDTO() {}

    public MeetingDTO(int meetingId, String title, String locationName, double locationLatitude, double locationLongitude, String introduction, String paymentMethod, String meetingType, Timestamp scheduledDate, Time exitRestrictionTime, int recruitMemberNumber, int recruitmentNumber, String gender, String eligibleAge, Timestamp createdDate, String participationMethod, String status, Timestamp endDate, int hostMemberId, int lastId) {
        this.meetingId = meetingId;
        this.title = title;
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.introduction = introduction;
        this.paymentMethod = paymentMethod;
        this.meetingType = meetingType;
        this.scheduledDate = scheduledDate;
        this.exitRestrictionTime = exitRestrictionTime;
        this.recruitMemberNumber = recruitMemberNumber;
        this.recruitmentNumber = recruitmentNumber;
        this.gender = gender;
        this.eligibleAge = eligibleAge;
        this.createdDate = createdDate;
        this.participationMethod = participationMethod;
        this.status = status;
        this.endDate = endDate;
        this.hostMemberId = hostMemberId;
        this.lastId = lastId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public Timestamp getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Timestamp scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Time getExitRestrictionTime() {
        return exitRestrictionTime;
    }

    public void setExitRestrictionTime(Time exitRestrictionTime) {
        this.exitRestrictionTime = exitRestrictionTime;
    }

    public int getRecruitMemberNumber() {
        return recruitMemberNumber;
    }

    public void setRecruitMemberNumber(int recruitMemberNumber) {
        this.recruitMemberNumber = recruitMemberNumber;
    }

    public int getRecruitmentNumber() {
        return recruitmentNumber;
    }

    public void setRecruitmentNumber(int recruitmentNumber) {
        this.recruitmentNumber = recruitmentNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEligibleAge() {
        return eligibleAge;
    }

    public void setEligibleAge(String eligibleAge) {
        this.eligibleAge = eligibleAge;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getParticipationMethod() {
        return participationMethod;
    }

    public void setParticipationMethod(String participationMethod) {
        this.participationMethod = participationMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getHostMemberId() {
        return hostMemberId;
    }

    public void setHostMemberId(int hostMemberId) {
        this.hostMemberId = hostMemberId;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    @Override
    public String toString() {
        return "MeetingDTO{" +
                "meetingId=" + meetingId +
                ", title='" + title + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationLatitude=" + locationLatitude +
                ", locationLongitude=" + locationLongitude +
                ", introduction='" + introduction + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", meetingType='" + meetingType + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", exitRestrictionTime=" + exitRestrictionTime +
                ", recruitMemberNumber=" + recruitMemberNumber +
                ", recruitmentNumber=" + recruitmentNumber +
                ", gender='" + gender + '\'' +
                ", eligibleAge='" + eligibleAge + '\'' +
                ", createdDate=" + createdDate +
                ", participationMethod='" + participationMethod + '\'' +
                ", status='" + status + '\'' +
                ", endDate=" + endDate +
                ", hostMemberId=" + hostMemberId +
                ", lastId=" + lastId +
                '}';
    }
}
