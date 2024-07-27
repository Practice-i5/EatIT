package com.i7.eatit.domain.chatting.controller;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    public String chat(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        UserInfoDTO loginUser = (UserInfoDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
            // 로그인 페이지로 리다이렉트, redirectUrl 파라미터에 현재 페이지를 설정
            return "redirect:/login/loginMain?redirectUrl=/chat";
        }

        model.addAttribute("username", loginUser.getNickname());
        model.addAttribute("roomName", "Default Room"); // 필요한 경우 실제 방 이름을 설정
        model.addAttribute("users", new ArrayList<>()); // 실제 사용자 리스트 추가

        return "chat/chat"; // chat.html 템플릿을 렌더링
    }

    // ChatMessage 클래스 정의
    public static class ChatMessage {
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
