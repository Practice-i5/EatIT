package com.i7.eatit.domain.user.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserSignupDTO {

    private int userCode;

    private String name;
    private String email;
    private String password;

    private int phoneNumber;
    private String nickname;
    private String loginMethod;

    private final String date;
    private String withdrawalStatus;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    public UserSignupDTO() {
        this.email = "email";
        this.date = DATE_FORMAT.format(new Date());
        this.withdrawalStatus = "N";
    }

    public UserSignupDTO(int userCode, String name, String email, String password, int phoneNumber,
                         String nickname, String loginMethod, String withdrawalStatus) {

        this.userCode = userCode;
        this.name = name;
        this.email = "email";
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.loginMethod = loginMethod;
        this.date = DATE_FORMAT.format(new Date());
        this.withdrawalStatus = "N";
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getDate() {
        return date;
    }

    public String getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(String withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    @Override
    public String toString() {
        return "UserSignupDTO{" +
                "userCode=" + userCode +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", nickname='" + nickname + '\'' +
                ", loginMethod='" + loginMethod + '\'' +
                ", date='" + date + '\'' +
                ", withdrawalStatus='" + withdrawalStatus + '\'' +
                '}';
    }
}