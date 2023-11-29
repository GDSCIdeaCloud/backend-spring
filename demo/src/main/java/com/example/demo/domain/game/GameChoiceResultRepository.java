package com.example.demo.domain.game;
import com.example.demo.db.entity.GameChoiceResultEntity;

public interface GameChoiceResultRepository {
    GameChoiceResultEntity save(GameChoiceResultEntity gameResultEntity);

}
