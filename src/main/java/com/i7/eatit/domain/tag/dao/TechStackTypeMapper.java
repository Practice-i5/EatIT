package com.i7.eatit.domain.tag.dao;

import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TechStackTypeMapper {
    List<TechStackTypeDTO> findAllTechStack();
}
