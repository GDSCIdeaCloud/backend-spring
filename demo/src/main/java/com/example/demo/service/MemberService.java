package com.example.demo.service;

import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder){
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberEntity save(MemberEntity memberEntity){
        return memberRepository.save(memberEntity);
    }

    public MemberEntity findByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public MemberEntity findByMemberId(Long memberId){
        return memberRepository.findByMemberId(memberId);
    }

    public MemberEntity findByEmailAndPassword(String email, String password){
        return memberRepository.findByEmailAndPassword(email, password);
    }

    public String encryptPassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean checkPassword(MemberEntity memberEntity, String password){
        return passwordEncoder.matches(password, memberEntity.getPassword());
    }

}
