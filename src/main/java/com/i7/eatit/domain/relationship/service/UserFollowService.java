package com.i7.eatit.domain.relationship.service;


import com.i7.eatit.domain.relationship.dao.FollowMapper;
import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFollowService {

    private FollowMapper followMapper;

    public UserFollowService(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }

    public List<FollowInfoDetailDTO> findFollowMember(int memberId){
        return followMapper.findFollowMember(memberId);
    }

    @Transactional
    public void deleteFollowMember(int followerId, int followeeId) {
        Map<String, Integer> followInfo = new HashMap<>();
        followInfo.put("followerId", followerId);
        followInfo.put("followeeId", followeeId);
        followMapper.deleteFollowMember(followInfo);
    }

    @Transactional
    public void insertFollowMember(int followerId, int followeeId) {
        Map<String, Integer> followInfo = new HashMap<>();
        followInfo.put("followerId", followerId);
        followInfo.put("followeeId", followeeId);
        followMapper.insertFollowMember(followInfo);
    }
}
