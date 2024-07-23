package com.i7.eatit.domain.user.dto;

public class UserLoginDTO {
    private int member_id;
    private String email;
    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(int member_id, String email, String password) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int memberId) {
        this.member_id = memberId;
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

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", member_id=" + member_id +
                '}';
    }
}
