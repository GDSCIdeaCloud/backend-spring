package com.example.demo.service;

import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.IdeaRepository;
import com.example.demo.db.repository.MemberRepository;
import com.example.demo.dto.AddIdeaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final MemberRepository memberRepository;

    public IdeaEntity save(Long memberId, AddIdeaRequest request) {
        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);

        return ideaRepository.save(request.toEntity(memberEntity));
    }
}
