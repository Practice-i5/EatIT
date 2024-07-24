package com.i7.eatit.domain.chatting.service;

import com.i7.eatit.domain.chatting.dao.GroupChatMapper;
import com.i7.eatit.domain.chatting.dto.GroupChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupChatService {
    @Autowired
    private GroupChatMapper groupChatMapper;

    public GroupChatDTO getGroupById(int groupId) {
        return groupChatMapper.findGroupById(groupId);
    }

    public List<GroupChatDTO> getGroupsByUserId(int userId) {
        return groupChatMapper.findGroupsByUserId(userId);
    }
}
