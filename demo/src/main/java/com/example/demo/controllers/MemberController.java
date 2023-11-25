package com.example.demo.controllers;

import com.example.demo.db.entity.MemberEntity;
import com.example.demo.service.MemberService;
import com.example.demo.api.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
 class RequestMember{
    String email;
    String password;
    String nickName;
    String imageUrl;
}

@Tag(name = "MemberController", description = "계정 관리를 위한 컨트롤러")
@RestController
@RequestMapping("/v1/controller")
public class MemberController {
    public final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @Operation(operationId = "register", summary = "회원가입", description = "요청을 검증한 뒤 이메일이 중복되지 않으면 DB에 계정을 추가함", tags = "MemberController")
    @PostMapping("/memberSave")
    public ResponseEntity<ApiResponse> save(
    @RequestBody RequestMember body
    ){
        MemberEntity memberEntity = new MemberEntity(
                body.getNickName(),
                body.getEmail(),
                body.getImageUrl(),
                body.getPassword());

        memberService.save(memberEntity);

        return ResponseEntity.ok(new ApiResponse("OK", "OK"));
    }
}