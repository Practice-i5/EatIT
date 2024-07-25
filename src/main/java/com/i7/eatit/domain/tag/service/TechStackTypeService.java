package com.i7.eatit.domain.tag.service;

import com.i7.eatit.domain.tag.dao.TechStackTypeMapper;
import com.i7.eatit.domain.tag.dto.TechStackTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackTypeService {

    private TechStackTypeMapper techStackTypeMapper;

    public TechStackTypeService(TechStackTypeMapper techStackTypeMapper) {
        this.techStackTypeMapper = techStackTypeMapper;
    }

    public void addNewTechStack(String techStackName){

    }

    public List<TechStackTypeDTO> findAllTechStack() {
        return techStackTypeMapper.findAllTechStack();
    }
}
