package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity(name = "idea")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdeaEntity {

    @Id
    @Column(name = "ideaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ideaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public IdeaEntity(MemberEntity memberEntity, String title, String content) {
        this.memberEntity = memberEntity;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
