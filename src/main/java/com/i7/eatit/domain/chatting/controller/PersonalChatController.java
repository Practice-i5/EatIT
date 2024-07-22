package com.i7.eatit.domain.chatting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
public class PersonalChatController {

    @GetMapping("chat-page")
    public void chat() {}
}
