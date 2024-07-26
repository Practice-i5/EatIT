package com.i7.eatit.admin.dto;

public class AdminLoginDto {

    private String adminEmail;
    private String adminPassword;

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminLoginDto{" +
            "adminEmail='" + adminEmail + '\'' +
            ", adminPassword='" + adminPassword + '\'' +
            '}';
    }
}
