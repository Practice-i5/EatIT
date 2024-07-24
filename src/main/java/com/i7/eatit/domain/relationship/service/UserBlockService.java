package com.i7.eatit.domain.relationship.service;

import com.i7.eatit.domain.relationship.dao.BlockMapper;
import com.i7.eatit.domain.relationship.dto.BlockInfoDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBlockService {

    private BlockMapper blockMapper;

    public UserBlockService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<BlockInfoDetailDTO> findBlockedMemberById(int memberId){
        return blockMapper.findBlockedMember(memberId);
    }


}
