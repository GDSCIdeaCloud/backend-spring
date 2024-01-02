package com.example.demo.service;

import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.IdeaRepository;
import com.example.demo.db.repository.MemberRepository;
import com.example.demo.dto.IdeaDtos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final MemberRepository memberRepository;

    public IdeaEntity save(IdeaDtos.AddIdeaRequest request) {
        MemberEntity memberEntity = memberRepository.findByMemberId(request.getMemberId());

        return ideaRepository.save(request.toEntity(memberEntity));
    }

    public IdeaEntity findOne(Long id) {
        return ideaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public List<IdeaEntity> findAll() {
        return ideaRepository.findAll();
    }

    public void delete(Long id) {
        IdeaEntity idea = ideaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        // 작성한 아이디어가 본인인지 확인하는 메서로 검증

        ideaRepository.deleteById(id);
    }

    public IdeaEntity update(Long id, IdeaDtos.UpdateIdeaRequest request) {
        IdeaEntity idea = ideaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        // 작성한 아이디어가 본인인지 확인하는 메서로 검증
        idea.update(request.getTitle(), request.getContent());

        return idea;
    }
}
