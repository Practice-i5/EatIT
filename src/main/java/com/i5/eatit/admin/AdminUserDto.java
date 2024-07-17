package com.i5.eatit.admin;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AdminUserDto {

    private String userId;
    private String userName;
    private String role;
    private Boolean isLockedAccount;
    private int reportedCount;
    private int penaltyScore;
    private int tryLogin;
    private Date joinDate;
}
