package com.i7.eatit.admin.dto;

import java.time.LocalDateTime;

public class AdminMemberDto {

    private int memberId;               // 회원 아이디
    private String email;               // 회원 이메일
    private String password;
    private String name;                // 회원 이름
    private String nickname;
    private String loginMethod;
    private String phoneNumber;
    private LocalDateTime createdDate;  // 가입 일시
    private String withdrawalStatus;    // 탈퇴 여부
    private int reportedCount;          // 누적 신고 횟수
    private int isStoppedByAdmin;

    public AdminMemberDto(int memberId, String email, String password, String name, String nickname,
        String loginMethod, String phoneNumber, LocalDateTime createdDate, String withdrawalStatus,
        int reportedCount, int isStoppedByAdmin) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.loginMethod = loginMethod;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.withdrawalStatus = withdrawalStatus;
        this.reportedCount = reportedCount;
        this.isStoppedByAdmin = isStoppedByAdmin;
    }

    public AdminMemberDto() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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

    public int getIsStoppedByAdmin() {
        return isStoppedByAdmin;
    }

    public void setIsStoppedByAdmin(int isStoppedByAdmin) {
        this.isStoppedByAdmin = isStoppedByAdmin;
    }
}
