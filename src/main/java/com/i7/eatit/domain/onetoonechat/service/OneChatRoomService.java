package com.i7.eatit.domain.onetoonechat.service;


import com.i7.eatit.domain.onetoonechat.dao.OneChatRoomDAO;
import com.i7.eatit.domain.onetoonechat.dto.OneChatRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneChatRoomService {

    @Autowired
    private OneChatRoomDAO oneChatRoomDAO;

    public List<OneChatRoomDTO> getAllChatRooms() {
        return oneChatRoomDAO.findAll();
    }

    public void createChatRoom(String name) {
        oneChatRoomDAO.save(new OneChatRoomDTO(name));
    }

    public void deleteChatRoom(int id) {
        oneChatRoomDAO.deleteById(id);
    }
}
