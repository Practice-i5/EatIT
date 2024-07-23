package com.i7.eatit.domain.user.service;

import com.i7.eatit.domain.user.dao.BlockMapper;
import com.i7.eatit.domain.user.dto.BlockInfoDetailDTO;
import org.springframework.stereotype.Service;

@Service
public class UserBlockService {

    private BlockMapper blockMapper;

    public UserBlockService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public BlockInfoDetailDTO findBlockedMemberById(int memberId){
        return blockMapper.findBlockedMember(memberId);
    }


}
