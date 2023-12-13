package com.example.demo.dto;

import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class IdeaDtos {

    @Getter
    public static class AddIdeaRequest {
        private Long memberId;
        private String title;
        private String content;

        public IdeaEntity toEntity(MemberEntity memberEntity) {
            return IdeaEntity.builder()
                    .title(title)
                    .content(content)
                    .memberEntity(memberEntity)
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UpdateIdeaRequest {
        private String title;
        private String content;
    }

    @Getter
    public static class IdeaResponse {
        private final String title;
        private final String content;

        public IdeaResponse(IdeaEntity idea) {
            this.title = idea.getTitle();
            this.content = idea.getContent();
        }
    }
}
