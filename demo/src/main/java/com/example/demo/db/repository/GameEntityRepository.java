package com.example.demo.db.repository;

import com.example.demo.db.entity.GameEntity;
import com.example.demo.domain.game.GameRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEntityRepository extends JpaRepository<GameEntity,Long>, GameRepository {
}
