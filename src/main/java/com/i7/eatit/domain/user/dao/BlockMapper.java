package com.i7.eatit.domain.user.dao;

import com.i7.eatit.domain.user.dto.BlockInfoDetailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlockMapper {
    BlockInfoDetailDTO findBlockedMember(int memberId);

}
