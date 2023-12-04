package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;



@Getter
@Setter
@Entity(name = "member")
public class MemberEntity {
    @Id
    @Column(name = "memberId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long memberId;
    @Column(name = "nickName")
    String nickName;
    @Column(name = "email")
    String email;
    @Column(name = "imageUrl")
    String imageUrl;
    @Column(name = "password")
    String password;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    LocalDateTime created_at;

    public MemberEntity(String nickName,String email,String imageUrl,String password){
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public MemberEntity() {

    }
}
