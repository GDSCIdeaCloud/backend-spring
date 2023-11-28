package com.example.demo.domain.game;

import com.example.demo.db.entity.GameEntity;
import java.util.List;

public interface GameRepository {
    GameEntity save(GameEntity gameEntity);
    GameEntity findByGameId(Long gameId);
    List<GameEntity> findAll();
}
