package com.i7.eatit.domain.user.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoDTO {

    private int member_id;

    private String email;
    private String password;
    private String name;

    private String nickname;
    private String loginMethod = "email";
    private String phoneNumber;

    private final String createdDate;
    private String withdrawalStatus = "N";
    private int reportedCount;

    private String gender;
    private int age;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    public UserInfoDTO() {
        this.createdDate = DATE_FORMAT.format(new Date());
    }

    public UserInfoDTO(int member_id, String name, String email, String password, String phoneNumber,
                       String nickname, String loginMethod, String withdrawalStatus, int reportedCount,
                       String gender, int age) {

        this.member_id = member_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.loginMethod = loginMethod;
        this.createdDate = DATE_FORMAT.format(new Date());
        this.withdrawalStatus = withdrawalStatus;
        this.reportedCount = reportedCount;
        this.gender = gender;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginMethod() {
        return loginMethod;
    }

    public void setLoginMethod(String loginMethod) {
        this.loginMethod = loginMethod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public int getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(int reportedCount) {
        this.reportedCount = reportedCount;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "member_id=" + member_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", loginMethod='" + loginMethod + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                ", reportedCount=" + reportedCount +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}