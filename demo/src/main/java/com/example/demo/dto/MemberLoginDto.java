package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginDto {
    private String email;
    private String password;
    MemberLoginDto(String email, String password){
        this.email = email;
        this.password = password;
    }
}
