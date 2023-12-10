package com.example.demo.dto;

import com.example.demo.db.entity.IdeaEntity;
import lombok.Getter;

@Getter
public class IdeaResponse {

    private final String title;
    private final String content;

    public IdeaResponse(IdeaEntity idea) {
        this.title = idea.getTitle();
        this.content = idea.getContent();
    }
}
