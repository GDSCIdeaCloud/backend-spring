package com.example.demo.db.repository;

import com.example.demo.db.entity.MemberEntity;

import java.util.List;

public interface MemberRepository {
    MemberEntity save(MemberEntity member);
    List<MemberEntity> findAll();

}
