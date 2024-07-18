package com.i7.eatit.admin;

import java.sql.Date;

public class UserDTO {

    private String userId;
    private String userName;
    private String role;
    private Boolean isLockedAccount;
    private int reportedCount;
    private int penaltyScore;
    private int tryLogin;
    private Date joinDate;

    public UserDTO() {}

    public UserDTO(String userId, String userName, String role, Boolean isLockedAccount, int reportedCount, int penaltyScore, int tryLogin, Date joinDate) {
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getLockedAccount() {
        return isLockedAccount;
    }

    public void setLockedAccount(Boolean lockedAccount) {
        isLockedAccount = lockedAccount;
    }

    public int getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(int reportedCount) {
        this.reportedCount = reportedCount;
    }

    public int getPenaltyScore() {
        return penaltyScore;
    }

    public void setPenaltyScore(int penaltyScore) {
        this.penaltyScore = penaltyScore;
    }

    public int getTryLogin() {
        return tryLogin;
    }

    public void setTryLogin(int tryLogin) {
        this.tryLogin = tryLogin;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
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
