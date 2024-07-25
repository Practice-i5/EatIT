package com.i7.eatit.domain.user.dto;

public class ProfileModifyDTO {
    private int memberId;
    private String nickname;
    private int age;
    private String gender;

    public ProfileModifyDTO() {}

    public ProfileModifyDTO(int memberId, String nickname, int age, String gender) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ProfileModifyDTO{" +
                "memberId=" + memberId +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
