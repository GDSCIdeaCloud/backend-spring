package com.example.demo.controllers;


import com.example.demo.api.ApiResponseDto;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberLoginDto;
import com.example.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MemberController", description = "계정 관리를 위한 컨트롤러")
@RestController
@RequestMapping("/v1/controller")
public class MemberController {
    public final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @Operation(operationId = "register", summary = "회원가입", description = "요청을 검증한 뒤 DB에 계정을 추가함", tags = "MemberController")
    @PostMapping("/memberSave")
    public ResponseEntity<ApiResponseDto<MemberEntity>> memberSave(
            @RequestBody MemberDto body
    ){
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        HttpStatus.CREATED,
                        memberService.save(
                                new MemberEntity(
                                        body.getNickName(),
                                        body.getEmail(),
                                        body.getImageUrl(),
                                        memberService.encryptPassword(body.getPassword())
                                ))));
    }
    @Operation(operationId = "login", summary = "로그인", description = "요청을 검증한 뒤 로그인", tags = "MemberController")
    @PostMapping("/memberLogin")
    public ResponseEntity<ApiResponseDto<MemberEntity>> memberLogin(
            @RequestBody MemberLoginDto body
    ) {
        MemberEntity memberEntity = memberService.findByEmail(body.getEmail());
        if (memberService.checkPassword(memberEntity, body.getPassword())){
            return ResponseEntity.ok(
                    ApiResponseDto.success(
                            HttpStatus.FOUND,
                            memberEntity
                    ));
        } else {
            return ResponseEntity.ok(
                    ApiResponseDto.success(
                            HttpStatus.NOT_FOUND,
                            null
                    ));
        }
    }

}