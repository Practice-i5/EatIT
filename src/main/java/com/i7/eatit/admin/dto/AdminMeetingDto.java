package com.i7.eatit.admin.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class AdminMeetingDto {

    private int meetingId;              // 모임 id
    private String title;               // 모임 제목
    private String locationName;        // 모임 장소명
    private double locationLatitude;    // 모임 위도
    private double locationLongitude;   // 모임 경도
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
    private int lastId;                 // 자동 생성된 meeting_id
    private int reportedCount;          // 모임이 신고 당한 횟수

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

    public int getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(int reportedCount) {
        this.reportedCount = reportedCount;
    }
}