package com.i7.eatit.domain.groupChat.controller;


import com.i7.eatit.domain.groupChat.dto.ChatMessageDTO;
import com.i7.eatit.domain.groupChat.dto.ChatRoomDTO;
import com.i7.eatit.domain.groupChat.service.ChatService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
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
    public String getAllChatRooms(@SessionAttribute(value = "loginUser", required = false) UserInfoDTO loginUser, Model model) {
        if (loginUser == null) {
            return "redirect:/login/loginMain"; // 로그인 페이지로 리다이렉트
        }
        List<ChatRoomDTO> chatRooms = chatService.getAllChatRooms();
        model.addAttribute("chatRooms", chatRooms);
        return "chatrooms";
    }

    @GetMapping("/{id}")
    public String getChatRoom(@PathVariable String id, @SessionAttribute(value = "loginUser", required = false) UserInfoDTO loginUser, Model model) {
        if (loginUser == null) {
            return "redirect:/login/loginMain"; // 로그인 페이지로 리다이렉트
        }
        ChatRoomDTO chatRoom = chatService.getAllChatRooms().stream().filter(room -> room.getId().equals(id)).findFirst().orElse(null);
        List<ChatMessageDTO> chatMessages = chatService.getChatMessagesByRoomId(id);
        model.addAttribute("chatRoom", chatRoom);
        model.addAttribute("chatMessages", chatMessages);
        return "chatroom";
    }

    @GetMapping("/userChatrooms")
    public String getUserChatRooms(@SessionAttribute("loginUser") UserInfoDTO loginUser, Model model) {
        List<ChatRoomDTO> chatRooms = chatService.getUserChatRooms(loginUser.getEmail());
        model.addAttribute("chatRooms", chatRooms);
        return "chatGroup/chatrooms";
    }
}
