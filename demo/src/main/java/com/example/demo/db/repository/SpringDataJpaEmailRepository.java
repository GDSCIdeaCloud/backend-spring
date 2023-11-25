package com.example.demo.db.repository;

import com.example.demo.db.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaEmailRepository extends JpaRepository<MemberEntity,Long>, MemberRepository {


}