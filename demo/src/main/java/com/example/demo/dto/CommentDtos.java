package com.example.demo.dto;

import com.example.demo.db.entity.CommentEntity;
import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

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

    @Getter
    public static class AddReCommentRequest {
        private Long ideaId;
        private Long memberId;
        private Long parentId;
        private String content;

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public CommentEntity toEntity(MemberEntity memberEntity, IdeaEntity ideaEntity, CommentEntity parent) {
            return CommentEntity.builder()
                    .memberEntity(memberEntity)
                    .ideaEntity(ideaEntity)
                    .parent(parent)
                    .content(content)
                    .build();
        }
    }

    public static class ReCommentDTO {
        private Long commentId;
        private Long ideaId;
        private Long parentId;
        private Long memberId;
        private String content;

        public ReCommentDTO(CommentEntity entity) {
            this.commentId = entity.getCommentId();
            this.ideaId = entity.getIdeaEntity().getIdeaId();
            this.parentId = entity.getParent().getCommentId();
            this.memberId = entity.getMemberEntity().getMemberId();
            this.content = entity.getContent();
        }
    }
}
