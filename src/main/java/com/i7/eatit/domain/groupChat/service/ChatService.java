package com.i7.eatit.domain.groupChat.service;


import com.i7.eatit.domain.groupChat.dto.ChatMessageDTO;
import com.i7.eatit.domain.groupChat.dto.ChatRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private RestTemplate restTemplate;

    private final String NODE_SERVER_URL = "http://localhost:3000";

    public List<ChatRoomDTO> getAllChatRooms() {
        ChatRoomDTO[] chatRooms = restTemplate.getForObject(NODE_SERVER_URL + "/chats/rooms", ChatRoomDTO[].class);
        return Arrays.asList(chatRooms);
    }

    public List<ChatMessageDTO> getChatMessagesByRoomId(String roomId) {
        ChatMessageDTO[] chatMessages = restTemplate.getForObject(NODE_SERVER_URL + "/chats/rooms/" + roomId + "/messages", ChatMessageDTO[].class);
        return Arrays.asList(chatMessages);
    }

    public List<ChatRoomDTO> getUserChatRooms(String username) {
        ChatRoomDTO[] chatRooms = restTemplate.getForObject(NODE_SERVER_URL + "/chats/user/" + username + "/rooms", ChatRoomDTO[].class);
        return Arrays.asList(chatRooms);
    }
}
