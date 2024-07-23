package com.i7.eatit.domain.meeting.model.common;

import java.util.List;

public class SearchCriteria {

    private String word;
    private List<String> interestsConditions;
    private String typeCondition = null;

    public SearchCriteria() {}

    public SearchCriteria(String word, List<String> interestsConditions, String typeCondition) {
        this.word = word;
        this.interestsConditions = interestsConditions;
        this.typeCondition = typeCondition;
    }

    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getInterestsConditions() {
        return interestsConditions;
    }

    public void setInterestsConditions(List<String> interestsConditions) {
        this.interestsConditions = interestsConditions;
    }

    public String getTypeCondition() {
        return typeCondition;
    }

    public void setTypeCondition(String typeCondition) {
        this.typeCondition = typeCondition;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "word='" + word + '\'' +
                ", interestsConditions=" + interestsConditions +
                ", typeCondition='" + typeCondition + '\'' +
                '}';
    }
}
