package com.i7.eatit.domain.onetoonechat.dao;

import com.i7.eatit.domain.onetoonechat.dto.OneChatRoomDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OneChatRoomDAO {

    @Select("SELECT * FROM tbl_onechatroom")
    List<OneChatRoomDTO> findAll();

    @Insert("INSERT INTO tbl_onechatroom (name) VALUES (#{name})")
    void save(OneChatRoomDTO oneChatRoom);

    @Delete("DELETE FROM tbl_onechatroom WHERE id = #{id}")
    void deleteById(int id);
}
