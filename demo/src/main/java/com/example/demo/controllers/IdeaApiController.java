package com.example.demo.controllers;

import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.dto.IdeaDtos.*;
import com.example.demo.service.IdeaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IdeaApiController {

    private final IdeaService ideaService;

    @Operation(operationId = "Idea Create", summary = "아이디어 등록", description = "아이디어 글 하나를 등록함", tags = "IdeaController")
    @PostMapping("/api/ideas")
    public ResponseEntity<IdeaEntity> addIdea(@RequestBody AddIdeaRequest request) {

        IdeaEntity savedIdea = ideaService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedIdea);
    }

    @Operation(operationId = "View All Idea", summary = "아이디어 목록 조회", description = "아이디어 글 목록을 조회함", tags = "IdeaController")
    @GetMapping("/api/ideas")
    public ResponseEntity<List<IdeaResponse>> findAllIdeas() {
        List<IdeaResponse> ideas = ideaService.findAll()
                .stream()
                .map(IdeaResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(ideas);
    }

    @Operation(operationId = "Idea Update", summary = "아이디어 수정", description = "아이디어 글 제목 또는 내용을 수정함", tags = "IdeaController")
    @PutMapping("/api/ideas/{id}")
    public ResponseEntity<IdeaEntity> updateIdea(@PathVariable Long id, @RequestBody UpdateIdeaRequest request) {
        IdeaEntity updateIdea = ideaService.update(id, request);

        return ResponseEntity.ok()
                .body(updateIdea);
    }

    @Operation(operationId = "Idea Delete", summary = "아이디어 삭제", description = "아이디어를 삭제함", tags = "IdeaController")
    @DeleteMapping("/api/ideas/{id}")
    public ResponseEntity<Void> deleteIdea(@PathVariable Long id) {
        ideaService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
