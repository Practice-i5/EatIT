package com.i7.eatit.domain.tag.service;


import com.i7.eatit.domain.tag.dao.MemberTechStackMapper;
import com.i7.eatit.domain.tag.dto.MemberTechStackDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberTechStackService {

    private MemberTechStackMapper memberTechStackMapper;

    public MemberTechStackService(MemberTechStackMapper memberTechStackMapper) {
        this.memberTechStackMapper = memberTechStackMapper;
    }

    @Transactional
    public void addMemberTechStack(MemberTechStackDTO memberTechStack){
        memberTechStackMapper.addMemberTechStack(memberTechStack);
    }

    @Transactional
    public void deleteMemberAllTechStack(int memberId){
        memberTechStackMapper.deleteMemberAllTechStack(memberId);
    }

    @Transactional
    public void updateMemberTechStack(List<MemberTechStackDTO> memberTechStackList){
        if (memberTechStackList.size()==0){
            System.out.println("오류!");
        }

        int memberId = memberTechStackList.get(0).getMemberId();
        deleteMemberAllTechStack(memberId);
        for (MemberTechStackDTO memberTechStack : memberTechStackList) {
            addMemberTechStack(memberTechStack);
        }
    }

}
