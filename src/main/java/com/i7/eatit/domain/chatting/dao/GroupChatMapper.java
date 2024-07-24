package com.i7.eatit.domain.chatting.dao;

import com.i7.eatit.domain.chatting.dto.GroupChatDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupChatMapper {
    GroupChatDTO findGroupById(@Param("groupId") int groupId);
    List<GroupChatDTO> findGroupsByUserId(@Param("userId") int userId);
}