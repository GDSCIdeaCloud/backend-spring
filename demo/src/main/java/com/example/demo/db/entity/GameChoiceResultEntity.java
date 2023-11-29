package com.example.demo.db.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.example.demo.domain.game.model.GameChoice;
import com.example.demo.domain.game.model.GameChoiceResult;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "gameChoiceResult")
public class GameChoiceResultEntity {
    @Id
    @Column(name = "gameChoiceResultId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameChoiceResultId;
    @ManyToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @ManyToOne(fetch = LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gameId")
    private GameEntity gameEntity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameChoice gameChoice;

    public GameChoiceResultEntity(Long gameChoiceResultId, MemberEntity memberEntity, GameEntity gameEntity,
                                  GameChoice gameChoice) {
        this.gameChoiceResultId = gameChoiceResultId;
        this.memberEntity = memberEntity;
        this.gameEntity = gameEntity;
        this.gameChoice = gameChoice;
    }

    public GameChoiceResultEntity(MemberEntity memberEntity, GameEntity gameEntity, GameChoice gameChoice) {
        this.gameChoiceResultId = null;
        this.memberEntity = memberEntity;
        this.gameEntity = gameEntity;
        this.gameChoice = gameChoice;
    }

    public GameChoiceResult toGameResult() {
        return new GameChoiceResult(gameChoiceResultId, memberEntity.getMemberId(), gameEntity.getGameId(), gameChoice);
    }
}
