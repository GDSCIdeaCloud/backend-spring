package com.example.demo.db.repository;

import com.example.demo.db.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberEntity save(MemberEntity member);
    List<MemberEntity> findAll();
    MemberEntity findByMemberId(Long memberId);

    MemberEntity findByEmailAndPassword(String email, String password);

    MemberEntity findByEmail(String email);

    Optional<MemberEntity> findById(Long id);


}
