package com.example.demo.service;

import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void save(MemberEntity memberEntity){
        memberRepository.save(memberEntity);
    }
}
