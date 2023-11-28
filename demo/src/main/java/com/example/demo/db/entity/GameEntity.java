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
@Entity(name = "gmae")
public class GameEntity {
    @Id
    @Column(name = "gameId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    private String title;

    private String choice1_img_url;
    private String choice2_img_url;

    private String choice1_name;
    private String choice2_name;

    private GameEntity(MemberEntity memberEntity, String title, String choice1_img_url, String choice2_img_url,
                       String choice1_name, String choice2_name) {
        this.memberEntity = memberEntity;
        this.title = title;
        this.choice1_img_url = choice1_img_url;
        this.choice2_img_url = choice2_img_url;
        this.choice1_name = choice1_name;
        this.choice2_name = choice2_name;
    }

    public GameEntity(MemberEntity memberEntity, Game game) {
        this(memberEntity,game.getTitle(),game.getChoice1_img_url(),game.getChoice2_img_url(),game.getChoice1_name(),game.getChoice2_name());
    }
    public Game toGame(){
        return new Game(gameId,memberEntity.getMemberId(),title,choice1_img_url,choice2_img_url,choice1_name,choice2_name);
    }
}
