package com.i7.eatit.domain.user.dto;

import java.sql.Date;

public class TechExperienceDTO {

    private Integer experienceId;
    private int memberId;
    private String companyName;
    private String description;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private String isCurrent;

    public TechExperienceDTO() {}

    public TechExperienceDTO(Integer experienceId, int memberId, String companyName, String description, Date startDate, Date endDate, String isCurrent) {
        this.experienceId = experienceId;
        this.memberId = memberId;
        this.companyName = companyName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrent = isCurrent;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
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

    public String getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(String isCurrent) {
        this.isCurrent = isCurrent;
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
                ", isCurrent='" + isCurrent + '\'' +
                '}';
    }
}
