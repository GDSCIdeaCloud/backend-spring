package com.example.demo.controllers;

import com.example.demo.api.ApiResponseDto;
import com.example.demo.dto.GameDtos.*;
import com.example.demo.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "GameController", description = "아이디어 클라우드 게임 관련 컨트롤러")
@RestController
@RequestMapping("/v1/controller/game")
@RequiredArgsConstructor
public class GameApiController {
    private final GameService gameService;
    @Operation(operationId = "View Single Game", summary = "게임 단일 조회", description = "참여할 게임을 조회함", tags = "GameController")
    @GetMapping(value = "", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<SingleGameViewDto>> getSingleGame(
            @RequestHeader("Authorization") Long memberId, @RequestParam("gameId") Long gameId) {
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        HttpStatus.OK,
                        new SingleGameViewDto(gameService.findGameByGameId(gameId))));
    }
    @Operation(operationId = "register", summary = "게임 등록", description = "요청을 검증한 뒤 게임을 등록함", tags = "GameController")
    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<SingleGameViewDto>> postGame(@RequestHeader("Authorization") Long memberId,
                                                                      @Valid @RequestBody PostGameRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        HttpStatus.CREATED,
                        new SingleGameViewDto(gameService.save(memberId, requestDto.toGame(memberId)))));
    }
    @Operation(operationId = "join", summary = "게임 참여", description = "요청을 검토한뒤 게임에 참여함", tags = "GameController")
    @PostMapping(value = "/join", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<JoinGameViewDto>> joinGame(@RequestHeader("Authorization") Long memberId,
                                                                    @Valid @RequestBody JoinGameRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        HttpStatus.OK,
                        new JoinGameViewDto(
                                gameService.joinGame(memberId, requestDto.getGameId(), requestDto.getChoice()))));
    }
    @Operation(operationId = "total", summary = "게임 목록 조회", description = "게임들을 조회함", tags = "GameController")
    @GetMapping(value = "/total", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ApiResponseDto<GamesViewDto>> getAllGames() {
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        HttpStatus.OK,
                        new GamesViewDto(gameService.findAll())));
    }

}
