package com.example.demo.service;

import com.example.demo.db.entity.GameEntity;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.MemberRepository;
import com.example.demo.domain.game.GameRepository;
import com.example.demo.domain.game.model.Game;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final MemberRepository memberRepository;

    public Game save(Long memberId, Game game) {
        MemberEntity memberEntity = memberRepository.findByMemberId(memberId);
        return gameRepository.save(new GameEntity(memberEntity, game)).toGame();
    }

    public Game findGameByGameId(Long gameId) {
        return gameRepository.findByGameId(gameId).toGame();
    }

    public List<Game> findAll() {
        return gameRepository.findAll().stream().map(GameEntity::toGame).toList();
    }
}
