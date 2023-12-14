package com.example.demo.service;

import com.example.demo.db.entity.CommentEntity;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.IdeaRepository;
import com.example.demo.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommtentService {

    private final IdeaRepository ideaRepository;
    private final MemberRepository memberRepository;

    public CommentEntity save(Long memberId) {
        MemberEntity memberEntity = memberRepository.findById(memberId);
    }
}
