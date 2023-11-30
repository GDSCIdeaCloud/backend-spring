package com.example.demo.dto;

import com.example.demo.db.entity.IdeaEntity;
import com.example.demo.db.entity.MemberEntity;

public class AddIdeaRequest {

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
