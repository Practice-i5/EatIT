package com.i7.eatit.admin.dto;

import java.sql.Date;

public class AdminUserDto {

    private String userId;
    private String userName;
    private String role;
    private Boolean isLockedAccount;
    private int reportedCount;
    private int penaltyScore;
    private int tryLogin;
    private Date joinDate;

    public AdminUserDto() {
    }

    public AdminUserDto(String userId, String userName, String role, Boolean isLockedAccount,
        int reportedCount, int penaltyScore, int tryLogin, Date joinDate) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.isLockedAccount = isLockedAccount;
        this.reportedCount = reportedCount;
        this.penaltyScore = penaltyScore;
        this.tryLogin = tryLogin;
        this.joinDate = joinDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public Boolean getLockedAccount() {
        return isLockedAccount;
    }

    public int getReportedCount() {
        return reportedCount;
    }

    public int getPenaltyScore() {
        return penaltyScore;
    }

    public int getTryLogin() {
        return tryLogin;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLockedAccount(Boolean lockedAccount) {
        isLockedAccount = lockedAccount;
    }

    public void setReportedCount(int reportedCount) {
        this.reportedCount = reportedCount;
    }

    public void setPenaltyScore(int penaltyScore) {
        this.penaltyScore = penaltyScore;
    }

    public void setTryLogin(int tryLogin) {
        this.tryLogin = tryLogin;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "AdminUserDto{" +
            "userId='" + userId + '\'' +
            ", userName='" + userName + '\'' +
            ", role='" + role + '\'' +
            ", isLockedAccount=" + isLockedAccount +
            ", reportedCount=" + reportedCount +
            ", penaltyScore=" + penaltyScore +
            ", tryLogin=" + tryLogin +
            ", joinDate=" + joinDate +
            '}';
    }
}
