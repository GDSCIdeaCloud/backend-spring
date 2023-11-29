package com.example.demo.domain.game.model;

import lombok.Getter;

@Getter
public class Game {
    private Long gameId;
    private Long memberId;

    private String title;

    private String choice1ImgUrl;
    private String choice2ImgUrl;

    private String choice1Name;
    private String choice2Name;

    public Game(Long gameId, Long memberId, String title, String choice1ImgUrl, String choice2ImgUrl,
                String choice1Name, String choice2Name) {
        this.gameId = gameId;
        this.memberId = memberId;
        this.title = title;
        this.choice1ImgUrl = choice1ImgUrl;
        this.choice2ImgUrl = choice2ImgUrl;
        this.choice1Name = choice1Name;
        this.choice2Name = choice2Name;
    }
    public Game(Long memberId, String title, String choice1ImgUrl, String choice2ImgUrl,
                String choice1Name, String choice2Name) {
        this.gameId = null;
        this.memberId = memberId;
        this.title = title;
        this.choice1ImgUrl = choice1ImgUrl;
        this.choice2ImgUrl = choice2ImgUrl;
        this.choice1Name = choice1Name;
        this.choice2Name = choice2Name;
    }
}
