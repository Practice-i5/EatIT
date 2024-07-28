package com.i7.eatit.domain.relationship.dao;

import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FollowMapper {
    List<FollowInfoDetailDTO> findFollowMember(Map<String, Integer> findFollowInfo);

    void deleteFollowMember(Map<String, Integer> deleteFollowInfo);

    void insertFollowMember(Map<String, Integer> followInfo);

    int countFollowMember(int memberId);
}
