package com.i7.eatit.domain.relationship.dao;

import com.i7.eatit.domain.relationship.dto.BlockInfoDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlockMapper {
    List<BlockInfoDetailDTO> findBlockedMember(int memberId);

    void deleteBlockedMember(Map<String, Integer> blockUserInfo);

    void insertBlockMember(Map<String, Integer> blockUserInfo);
}
