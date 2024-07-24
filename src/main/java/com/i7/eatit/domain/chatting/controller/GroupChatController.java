package com.i7.eatit.domain.chatting.controller;

import com.i7.eatit.domain.chatting.dto.GroupChatDTO;
import com.i7.eatit.domain.chatting.service.GroupChatService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("chatGroup")
public class GroupChatController {

    private GroupChatService groupChatService;
    private UserService userService;

    public GroupChatController(GroupChatService groupChatService, UserService userService) {
        this.groupChatService = groupChatService;
        this.userService = userService;
    }

    public GroupChatController() {
    }

    @GetMapping("/chat-page")
    public String chat(Model model, Principal principal) {
        String username = principal.getName();
        UserInfoDTO user = userService.getUserByUsername(username);
        List<GroupChatDTO> groupChats = groupChatService.getGroupsByUserId(user.getMember_id());
        model.addAttribute("groupChats", groupChats);
        return "chat";
    }
}
