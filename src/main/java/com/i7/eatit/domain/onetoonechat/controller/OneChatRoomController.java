package com.i7.eatit.domain.onetoonechat.controller;

import com.i7.eatit.domain.onetoonechat.dto.OneChatRoomDTO;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import com.i7.eatit.domain.onetoonechat.service.OneChatRoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/onechatroom")
public class OneChatRoomController {

    @Value("${node.server.url}")
    private String nodeServerUrl;

    @Autowired
    private OneChatRoomService oneChatRoomService;

    private static final Logger logger = LoggerFactory.getLogger(OneChatRoomController.class);

    @GetMapping("/chat-room")
    public String chatRoom(@RequestParam("username") String username, @RequestParam("room") String room, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("roomName", room);
        return "chat/chat";
    }

    @GetMapping("/chat-index")
    public String chatIndex(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        UserInfoDTO loginUser = (UserInfoDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login/loginMain";
        }

        List<OneChatRoomDTO> oneChatRooms = oneChatRoomService.getAllChatRooms();
        model.addAttribute("oneChatRooms", oneChatRooms);
        return "chat/chat-index";
    }

    @PostMapping("/create")
    public String createChatRoom(@RequestParam("name") String name) {
        oneChatRoomService.createChatRoom(name);
        return "redirect:/onechatroom/chat-index";
    }

    @PostMapping("/delete")
    public String deleteChatRoom(@RequestParam("id") int id) {
        oneChatRoomService.deleteChatRoom(id);
        return "redirect:/onechatroom/chat-index";
    }

    @PostMapping("/send-message")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OneChatRoomController.ChatMessage> request = new HttpEntity<>(chatMessage, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(nodeServerUrl + "/messages", HttpMethod.POST, request, String.class);
            return response;
        } catch (Exception e) {
            logger.error("Error sending message", e); // 로그에 오류 메시지 출력
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending message: " + e.getMessage());
        }
    }

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
