package com.i7.eatit.domain.relationship.service;

import com.i7.eatit.domain.relationship.dao.BlockMapper;
import com.i7.eatit.domain.relationship.dto.BlockInfoDetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBlockService {

    private BlockMapper blockMapper;

    public UserBlockService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<BlockInfoDetailDTO> findBlockedMemberById(int memberId){
        return blockMapper.findBlockedMember(memberId);
    }

    @Transactional
    public void deleteBlockMember(int blockingMemberId, int blockedMemberId){
        Map<String, Integer> blockInfo = new HashMap<>();

        blockInfo.put("blockingMemberId", blockingMemberId);
        blockInfo.put("blockedMemberId", blockedMemberId);

        blockMapper.deleteBlockedMember(blockInfo);

    }

    @Transactional
    public void insertBlockMember(int blockingMemberId, int blockedMemberId){
        Map<String, Integer> blockInfo = new HashMap<>();

        blockInfo.put("blockingMemberId", blockingMemberId);
        blockInfo.put("blockedMemberId", blockedMemberId);

        blockMapper.insertBlockMember(blockInfo);
    }


}
