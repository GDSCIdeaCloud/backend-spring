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
        private String choice1ImgUrl;
        private String choice2ImgUrl;
        private String choice1Name;
        private String choice2Name;
        public SingleGameViewDto(Game game) {
            this.gameId = game.getGameId();
            this.memberId = game.getMemberId();
            this.title = game.getTitle();
            this.choice1ImgUrl = game.getChoice1ImgUrl();
            this.choice2ImgUrl = game.getChoice2ImgUrl();
            this.choice1Name = game.getChoice1Name();
            this.choice2Name = game.getChoice2Name();
        }
    }

    @RequiredArgsConstructor
    public static class PostGameRequestDto {
        private final String title;
        private final String choice1ImgUrl;
        private final String choice2ImgUrl;
        private final String choice1Name;
        private final String choice2Name;
        public Game toGame(Long memberId) {
            return new Game(memberId, title, choice1ImgUrl, choice2ImgUrl, choice1Name, choice2Name);
        }
    }

    public static class GamesViewDto {
        private final List<SingleGameViewDto> games;

        public GamesViewDto(List<Game> games) {
            this.games = games.stream().map(SingleGameViewDto::new).toList();
        }
    }
}
