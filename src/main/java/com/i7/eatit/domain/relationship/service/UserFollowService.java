package com.i7.eatit.domain.relationship.service;


import com.i7.eatit.domain.relationship.dao.FollowMapper;
import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFollowService {

    private FollowMapper followMapper;

    public UserFollowService(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    public List<FollowInfoDetailDTO> findFollowMember(int memberId){
        return followMapper.findFollowMember(memberId);
    }
}
