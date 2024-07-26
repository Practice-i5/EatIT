package com.i7.eatit.admin.dto;

import java.time.LocalDateTime;

public class AdminMemberDto {

    private int memberId;               // 회원 아이디
    private String email;               // 회원 이메일
    private String password;            // 회원의 비밀번호
    private String name;                // 회원 이름
    private String nickname;            // 회원의 닉네임
    private String loginMethod;         // 회원의 로그인 수단
    private String phoneNumber;         // 회원의 전화 번호
    private LocalDateTime createdDate;  // 회원의 가입 일시
    private String withdrawalStatus;    // 회원의 탈퇴 여부
    private int reportedCount;          // 회원의 누적 신고 횟수
    private String gender;              // 회원의 성별
    private int age;                    // 회원의 나이
    private int isStoppedByAdmin;       // 회원의 정지 여부 상태. 관리자가 정지를 먹인 회원이면 1, 그렇지 않으면 0

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

    public int getIsStoppedByAdmin() {
        return isStoppedByAdmin;
    }

    public void setIsStoppedByAdmin(int isStoppedByAdmin) {
        this.isStoppedByAdmin = isStoppedByAdmin;
    }
}
