package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "ideaLike")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdeaLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideaLikeId")
    private Long ideaLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ideaID")
    private IdeaEntity ideaEntity;

    @Builder
    public IdeaLikeEntity(MemberEntity memberEntity, IdeaEntity ideaEntity) {
        this.memberEntity = memberEntity;
        this.ideaEntity = ideaEntity;
    }
}
