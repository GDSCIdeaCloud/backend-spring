package com.example.demo.domain.game.model;

public class GameChoiceResult {
    private Long gameChoiceResultId;
    private Long gameId;
    private Long memberId;
    private GameChoice gameChoice;

    public GameChoiceResult(Long gameChoiceResultId, Long gameId, Long memberId, GameChoice gameChoice) {
        this.gameChoiceResultId = gameChoiceResultId;
        this.gameId = gameId;
        this.memberId = memberId;
        this.gameChoice = gameChoice;
    }
}
