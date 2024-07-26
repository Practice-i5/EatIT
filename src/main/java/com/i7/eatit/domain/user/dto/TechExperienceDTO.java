package com.i7.eatit.domain.user.dto;

import java.sql.Date;

public class TechExperienceDTO {

    private int experienceId;
    private int memberId;
    private String companyName;
    private String description;
    private java.sql.Date startDate;
    private java.sql.Date endDate;

    public TechExperienceDTO() {}

    public TechExperienceDTO(int experienceId, int memberId, String companyName, String description, Date startDate, Date endDate) {
        this.experienceId = experienceId;
        this.memberId = memberId;
        this.companyName = companyName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "TechExperienceDTO{" +
                "experienceId=" + experienceId +
                ", memberId=" + memberId +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
