package com.i7.eatit.common.DTO;

public class techStackDTO {
    private int id;
    private String name;
    private String engName;

    techStackDTO() {}

    public techStackDTO(int id, String name, String engName) {
        this.id = id;
        this.name = name;
        this.engName = engName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    @Override
    public String toString() {
        return "techStack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engName='" + engName + '\'' +
                '}';
    }
}
