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

    @Column(name = "choice1ImgUrl")
    private String choice1ImgUrl;

    @Column(name = "choice2ImgUrl")
    private String choice2ImgUrl;

    @Column(name = "choice1Name")
    private String choice1Name;

    @Column(name = "choice2Name")
    private String choice2Name;

    private GameEntity(MemberEntity memberEntity, String title, String choice1ImgUrl, String choice2ImgUrl,
                       String choice1Name, String choice2Name) {
        this.memberEntity = memberEntity;
        this.title = title;
        this.choice1ImgUrl = choice1ImgUrl;
        this.choice2ImgUrl = choice2ImgUrl;
        this.choice1Name = choice1Name;
        this.choice2Name = choice2Name;
    }

    public GameEntity(MemberEntity memberEntity, Game game) {
        this(memberEntity, game.getTitle(), game.getChoice1ImgUrl(), game.getChoice2ImgUrl(), game.getChoice1Name(), game.getChoice2Name());
    }

    public Game toGame() {
        return new Game(gameId, memberEntity.getMemberId(), title, choice1ImgUrl, choice2ImgUrl, choice1Name, choice2Name);
    }
}