package com.example.demo.controllers;

import com.example.demo.db.entity.CommentEntity;
import com.example.demo.dto.CommentDtos.*;
import com.example.demo.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @Operation(operationId = "Comment Create", summary = "댓글 등록", description = "아이디어에 댓글을 작성함", tags = "CommentController")
    @PostMapping("/api/comment")
    public ResponseEntity<CommentEntity> addComment(@RequestBody AddCommentRequest request) {

        CommentEntity savedComment = commentService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedComment);
    }
}
