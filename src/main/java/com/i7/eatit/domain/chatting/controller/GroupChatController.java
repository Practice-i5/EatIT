package com.i7.eatit.domain.chatting.controller;

import com.i7.eatit.domain.chatting.dto.GroupChatDTO;
import com.i7.eatit.domain.chatting.service.GroupChatService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/chatGroup")
public class GroupChatController {

    private final GroupChatService groupChatService;
    private final UserService userService;

    @Autowired
    public GroupChatController(GroupChatService groupChatService, UserService userService) {
        this.groupChatService = groupChatService;
        this.userService = userService;
    }

    @GetMapping("/chat-page")
    public String chat(Model model, HttpSession session) {
        UserInfoDTO user = (UserInfoDTO) session.getAttribute("loginUser");

        if (user == null) {
            return "redirect:/login/loginMain"; // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
        }

        List<GroupChatDTO> groupChats = groupChatService.getGroupsByUserId(user.getMember_id());
        model.addAttribute("groupChats", groupChats);
        return "chatGroup/chat-page";
    }
}