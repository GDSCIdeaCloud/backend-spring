package com.example.demo.domain.game;

import com.example.demo.db.entity.GameEntity;
import java.util.List;
import java.util.Optional;

public interface GameRepository {
    GameEntity save(GameEntity gameEntity);
    Optional<GameEntity> findByGameId(Long gameId);
    List<GameEntity> findAll();
}
