package com.i7.eatit.domain.tag.dto;

import java.util.List;

public class InsertInterestRelDTO {

    private int relation_id;
    private List<String> interestsConditions;
    public int meeting_id;

    public InsertInterestRelDTO() {}

    public InsertInterestRelDTO(int relation_id, List<String> interestsConditions, int meeting_id) {
        this.relation_id = relation_id;
        this.interestsConditions = interestsConditions;
        this.meeting_id = meeting_id;
    }

    public int getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }

    public List<String> getInterestsConditions() {
        return interestsConditions;
    }

    public void setInterestsConditions(List<String> interestsConditions) {
        this.interestsConditions = interestsConditions;
    }

    public int getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(int meeting_id) {
        this.meeting_id = meeting_id;
    }

    @Override
    public String toString() {
        return "InsertInterestRelDTO{" +
                "relation_id=" + relation_id +
                ", interestsConditions=" + interestsConditions +
                ", meeting_id=" + meeting_id +
                '}';
    }
}
