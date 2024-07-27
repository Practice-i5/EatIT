package com.i7.eatit.domain.chatting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class ChatController {

    @Value("${node.server.url}")
    private String nodeServerUrl;

    @PostMapping("/send-message")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ChatMessage> request = new HttpEntity<>(chatMessage, headers);
        return restTemplate.exchange(nodeServerUrl + "/messages", HttpMethod.POST, request, String.class);
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        // 필요한 데이터를 모델에 추가
        model.addAttribute("roomName", "방 이름");
        model.addAttribute("users", new ArrayList<>()); // 실제 사용자 리스트 추가
        return "chat/chat"; // chat.html 템플릿을 렌더링
    }

    // ChatMessage 클래스 정의
    static class ChatMessage {
        private String username;
        private String room;
        private String message;

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
