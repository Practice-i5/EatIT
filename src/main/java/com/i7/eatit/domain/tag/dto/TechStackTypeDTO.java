package com.i7.eatit.domain.tag.dto;

public class TechStackTypeDTO {
    private int code;
    private String name;

    public TechStackTypeDTO() {}

    public TechStackTypeDTO(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "techStackTypeDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}

