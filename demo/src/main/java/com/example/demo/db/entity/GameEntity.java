package com.example.demo.db.entity;

import static jakarta.persistence.FetchType.EAGER;

import com.example.demo.domain.game.model.Game;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "game")
public class GameEntity {
    @Id
    @Column(name = "gameId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    @ManyToOne(fetch = EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @Column(name = "title")
    private String title;
    @Column(name = "choiceAImgUrl")
    private String choiceAImgUrl;
    @Column(name = "choiceBImgUrl")
    private String choiceBImgUrl;
    @Column(name = "choiceAName")
    private String choiceAName;
    @Column(name = "choiceBName")
    private String choiceBName;
    @Column(name = "choiceACount")
    private Integer choiceACount;
    @Column(name = "choiceBCount")
    private Integer choiceBCount;

    private GameEntity(Long gameId,MemberEntity memberEntity, String title, String choiceAImgUrl, String choiceBImgUrl, String choiceAName, String choiceBName,Integer choiceACount,Integer choiceBCount) {
        this.gameId = gameId;
        this.memberEntity = memberEntity;
        this.title = title;
        this.choiceAImgUrl = choiceAImgUrl;
        this.choiceBImgUrl = choiceBImgUrl;
        this.choiceAName = choiceAName;
        this.choiceBName = choiceBName;
        this.choiceACount = choiceACount;
        this.choiceBCount = choiceBCount;
    }
    @Builder(builderClassName = "GameRegister", builderMethodName = "forRegisterGame")
    public GameEntity(MemberEntity memberEntity, Game game) {
        this(game.getGameId(),memberEntity, game.getTitle(), game.getChoiceAImgUrl(), game.getChoiceBImgUrl(), game.getChoiceAName(), game.getChoiceBName(),0,0);
    }
    @Builder(builderClassName = "GameUpdate", builderMethodName = "forUpdateGame")
    public GameEntity(Game game,GameEntity gameEntity) {
        this(game.getGameId(),gameEntity.getMemberEntity(), game.getTitle(), game.getChoiceAImgUrl(), game.getChoiceBImgUrl(), game.getChoiceAName(), game.getChoiceBName(),game.getChoiceACount(),game.getChoiceBCount());
    }
    public Game toGame() {
        return new Game(gameId, memberEntity.getMemberId(), title, choiceAImgUrl, choiceBImgUrl, choiceAName, choiceBName,choiceACount,choiceBCount);
    }
}