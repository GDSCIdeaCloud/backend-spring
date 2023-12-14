package com.example.demo.dto;

import com.example.demo.db.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    String email;
    String password;
    String nickName;
    String imageUrl;
    public MemberDto(MemberEntity memberEntity){
        this.email = memberEntity.getEmail();
        this.password = memberEntity.getPassword();
        this.nickName = memberEntity.getNickName();
        this.imageUrl = memberEntity.getImageUrl();
    }
}
