package com.example.demo.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
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

    public MemberEntity(String nickName,String email,String imageUrl,String password){
        this.nickName = nickName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public MemberEntity() {

    }
}
