package com.example.demo.controllers;

import com.example.demo.api.ApiResponseDto;
import com.example.demo.dto.GameDtos.GamesViewDto;
import com.example.demo.dto.GameDtos.PostGameRequestDto;
import com.example.demo.dto.GameDtos.SingleGameViewDto;
import com.example.demo.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "GameController ", description = "아이디어 클라우드 게임 생성 및 목록 조회")
@RestController
@RequestMapping("/v1/controller/game")
@RequiredArgsConstructor
public class GameApiController {
    private final GameService gameService;

    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<SingleGameViewDto>> getSingleGame(
            @RequestHeader("Authorization") Long memberId, @RequestParam("gameId") Long gameId) {
        return ResponseEntity.ok(ApiResponseDto.success(HttpStatus.OK, new SingleGameViewDto(gameService.findGameByGameId(gameId))));
    }

    @PostMapping(value = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<SingleGameViewDto>> postGame(@RequestHeader("Authorization") Long memberId,
                                                                      @Valid @RequestBody PostGameRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponseDto.success(HttpStatus.CREATED,new SingleGameViewDto(gameService.save(memberId, requestDto.toGame(memberId)))));
    }

    @GetMapping(value = "/total", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<GamesViewDto>> getAllGames() {
        return ResponseEntity.ok(ApiResponseDto.success(HttpStatus.OK, new GamesViewDto(gameService.findAll())));
    }

}
