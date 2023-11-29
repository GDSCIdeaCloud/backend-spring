package com.example.demo.domain.game.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Game {
    private Long gameId;
    private Long memberId;
    private String title;
    private String choiceAImgUrl;
    private String choiceBImgUrl;
    private String choiceAName;
    private String choiceBName;
    private Integer choiceACount;
    private Integer choiceBCount;

    public Game(Long gameId, Long memberId, String title, String choiceAImgUrl, String choiceBImgUrl,
                String choiceAName, String choiceBName,Integer choiceACount,Integer choiceBCount) {
        this.gameId = gameId;
        this.memberId = memberId;
        this.title = title;
        this.choiceAImgUrl = choiceAImgUrl;
        this.choiceBImgUrl = choiceBImgUrl;
        this.choiceAName = choiceAName;
        this.choiceBName = choiceBName;
        this.choiceACount = choiceACount;
        this.choiceBCount = choiceBCount;
    }

    @Builder(builderClassName = "RegisterGame", builderMethodName = "ForRegisterGame")
    public Game(Long memberId, String title, String choiceAImgUrl, String choiceBImgUrl,
                String choiceAName, String choiceBName) {
        this.gameId = null;
        this.memberId = memberId;
        this.title = title;
        this.choiceAImgUrl = choiceAImgUrl;
        this.choiceBImgUrl = choiceBImgUrl;
        this.choiceAName = choiceAName;
        this.choiceBName = choiceBName;
    }

    public void updateChoiceCount(GameChoice choice) {
        if (choice.equals(GameChoice.A)) {
            choiceACount++;
        }
        if (choice.equals(GameChoice.B)) {
            choiceBCount++;
        }
    }

    public Integer getTotalCount() {
        return choiceACount + choiceBCount;
    }

    public Double getChoiceARatio() {
        if (getTotalCount() > 0) {
            return Math.round(((double) choiceACount / getTotalCount()) * 100.0 * 1000.0) / 1000.0;
        }
        return 0.0;
    }

    public Double getChoiceBRatio() {
        if (getTotalCount() > 0) {
            return Math.round(((double) choiceBCount / getTotalCount()) * 100.0 * 1000.0) / 1000.0;
        }
        return 0.0;
    }

}
