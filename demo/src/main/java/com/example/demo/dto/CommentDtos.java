package com.example.demo.dto;

import com.example.demo.db.entity.CommentEntity;
import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;
import lombok.Getter;

public class CommentDtos {

    @Getter
    public static class AddCommentRequest {
        private Long ideaId;
        private Long memberId;
        private String content;

        public CommentEntity toEntity(MemberEntity memberEntity, IdeaEntity ideaEntity) {
            return CommentEntity.builder()
                    .memberEntity(memberEntity)
                    .ideaEntity(ideaEntity)
                    .content(content)
                    .build();
        }
    }
}
