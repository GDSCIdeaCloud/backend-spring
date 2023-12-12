package com.example.demo.dto;

import com.example.demo.domain.game.model.Game;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class GameDtos {
    @Getter
    @RequiredArgsConstructor
    public static class SingleGameViewDto {
        private Long gameId;
        private Long memberId;
        private String title;
        private String choiceAImgUrl;
        private String choiceBImgUrl;
        private String choiceAName;
        private String choiceBName;
        public SingleGameViewDto(Game game) {
            this.gameId = game.getGameId();
            this.memberId = game.getMemberId();
            this.title = game.getTitle();
            this.choiceAImgUrl = game.getChoiceAImgUrl();
            this.choiceBImgUrl = game.getChoiceBImgUrl();
            this.choiceAName = game.getChoiceAName();
            this.choiceBName = game.getChoiceBName();
        }
    }
    @Getter
    public static class PostGameRequestDto {
        private  Long memberId;
        private  String title;
        private  String choiceAImgUrl;
        private  String choiceBImgUrl;
        private  String choiceAName;
        private  String choiceBName;
        public Game toGame() {
            return Game.ForRegisterGame()
                    .title(this.title)
                    .memberId(this.memberId)
                    .choiceAImgUrl(this.choiceAImgUrl)
                    .choiceBImgUrl(this.choiceBImgUrl)
                    .choiceAName(this.choiceAName)
                    .choiceBName(this.choiceBName)
                    .build();
        }
    }
    @Getter
    public static class GamesViewDto {
        private final List<SingleGameViewDto> games;

        public GamesViewDto(List<Game> games) {
            this.games = games.stream().map(SingleGameViewDto::new).toList();
        }
    }
    @Getter
    public static class JoinGameRequestDto {
        private Long memberId;
        private  Long gameId;
        private  String choice;
    }
    @Getter
    public static  class JoinGameViewDto {
        private final Long gameId;
        private final Integer totalCount;
        private final Integer choiceACount;
        private final Integer choiceBCount;
        private final Double choiceARatio;
        private final Double choiceBRatio;
        public JoinGameViewDto(Game game) {
            this.gameId = game.getGameId();
            this.totalCount = game.getTotalCount();
            this.choiceACount = game.getChoiceACount();
            this.choiceBCount = game.getChoiceBCount();
            this.choiceARatio = game.getChoiceARatio();
            this.choiceBRatio = game.getChoiceBRatio();
        }
    }
}
