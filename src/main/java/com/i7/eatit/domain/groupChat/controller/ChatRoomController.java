package com.i7.eatit.domain.user.controller;

import com.i7.eatit.domain.user.dto.ChatMessageDTO;
import com.i7.eatit.domain.user.dto.ChatRoomDTO;
import com.i7.eatit.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chatrooms")
public class ChatRoomController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public String getAllChatRooms(Model model) {
        List<ChatRoomDTO> chatRooms = chatService.getAllChatRooms();
        model.addAttribute("chatRooms", chatRooms);
        return "chatrooms";
    }

    @GetMapping("/{id}")
    public String getChatRoom(@PathVariable String id, Model model) {
        ChatRoomDTO chatRoom = chatService.getAllChatRooms().stream().filter(room -> room.getId().equals(id)).findFirst().orElse(null);
        List<ChatMessageDTO> chatMessages = chatService.getChatMessagesByRoomId(id);
        model.addAttribute("chatRoom", chatRoom);
        model.addAttribute("chatMessages", chatMessages);
        return "chatroom";
    }
}
