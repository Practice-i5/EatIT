package com.i7.eatit.admin.service;

import static com.i7.eatit.admin.session.Template.getSqlSession;

import com.i7.eatit.admin.dto.AdminMemberDto;
import com.i7.eatit.admin.mapper.DynamicSqlMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public List<AdminMemberDto> findAll() {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        return null;
    }
}
