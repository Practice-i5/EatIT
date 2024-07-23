package com.i7.eatit.domain.meeting.model.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class MeetingDTO {

    private int meetingId;
    private String title;
    private String locationName;
    private double locationLatitude;
    private double locationLongitude;
    private String introduction;
    private String paymentMethod;
    private String meetingType;
    private String interests;
    private Timestamp scheduledDate;
    private Time exitRestrictionTime;
    private int recruitmentNumber;
    private String gender;
    private String eligibleAge;
    private Timestamp createdDate;
    private String participationMethod;
    private String status;
    private Timestamp endDate;
    private int hostMemberId;

    public MeetingDTO() {}

    public MeetingDTO(int meetingId, String title, String locationName, double locationLatitude, double locationLongitude, String introduction, String paymentMethod, String meetingType, String interests, Timestamp scheduledDate, Time exitRestrictionTime, int recruitmentNumber, String gender, String eligibleAge, Timestamp createdDate, String participationMethod, String status, Timestamp endDate, int hostMemberId) {
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
        this.recruitmentNumber = recruitmentNumber;
        this.gender = gender;
        this.eligibleAge = eligibleAge;
        this.createdDate = createdDate;
        this.participationMethod = participationMethod;
        this.status = status;
        this.endDate = endDate;
        this.hostMemberId = hostMemberId;
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

    public String getInterests() { return interests; }

    public void setInterests(String interests) { this.interests = interests; }

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

    @Override
    public String toString() {
        return "MeetingDTO{" +
                "meetingId='" + meetingId + '\'' +
                ", title='" + title + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationLatitude=" + locationLatitude +
                ", locationLongitude=" + locationLongitude +
                ", introduction='" + introduction + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", meetingType='" + meetingType + '\'' +
                ", interests='" + interests + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", exitRestrictionTime=" + exitRestrictionTime +
                ", recruitmentNumber=" + recruitmentNumber +
                ", gender='" + gender + '\'' +
                ", eligibleAge='" + eligibleAge + '\'' +
                ", createdDate=" + createdDate +
                ", participationMethod='" + participationMethod + '\'' +
                ", status='" + status + '\'' +
                ", endDate=" + endDate +
                ", hostMemberId=" + hostMemberId +
                '}';
    }
}
