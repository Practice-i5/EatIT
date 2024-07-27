package com.i7.eatit.domain.onetoonechat.dto;

public class OneChatRoomDTO {

    private int id;
    private String name;

    public OneChatRoomDTO() {}

    public OneChatRoomDTO(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "OneChatRoomDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
