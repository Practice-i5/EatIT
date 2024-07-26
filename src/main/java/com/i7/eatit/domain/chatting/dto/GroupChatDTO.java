package com.i7.eatit.domain.chatting.dto;

import com.i7.eatit.domain.user.dto.UserInfoDTO;

import java.util.List;

public class GroupChatDTO {
    private Long id;
    private String name;
    private List<UserInfoDTO> users;

    public GroupChatDTO(Long id, String name, List<UserInfoDTO> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public GroupChatDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserInfoDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfoDTO> users) {
        this.users = users;
    }
}
