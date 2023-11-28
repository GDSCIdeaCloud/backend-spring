package com.example.demo.domain.game.model;

import lombok.Getter;

@Getter
public class Game {
    private Long gameId;
    private Long memberId;

    private String title;

    private String choice1_img_url;
    private String choice2_img_url;

    private String choice1_name;
    private String choice2_name;

    public Game(Long gameId, Long memberId, String title, String choice1_img_url, String choice2_img_url,
                String choice1_name, String choice2_name) {
        this.gameId = gameId;
        this.memberId = memberId;
        this.title = title;
        this.choice1_img_url = choice1_img_url;
        this.choice2_img_url = choice2_img_url;
        this.choice1_name = choice1_name;
        this.choice2_name = choice2_name;
    }
}
