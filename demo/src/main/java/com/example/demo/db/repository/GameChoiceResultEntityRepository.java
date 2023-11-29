package com.example.demo.db.repository;

import com.example.demo.db.entity.GameChoiceResultEntity;
import com.example.demo.domain.game.GameChoiceResultRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameChoiceResultEntityRepository extends JpaRepository<GameChoiceResultEntity,Long>, GameChoiceResultRepository {
}
