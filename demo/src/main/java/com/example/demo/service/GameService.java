package com.example.demo.service;

import com.example.demo.db.entity.GameChoiceResultEntity;
import com.example.demo.db.entity.GameEntity;
import com.example.demo.db.entity.MemberEntity;
import com.example.demo.db.repository.MemberRepository;
import com.example.demo.domain.game.GameChoiceResultRepository;
import com.example.demo.domain.game.GameRepository;
import com.example.demo.domain.game.model.Game;
import com.example.demo.domain.game.model.GameChoice;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;
    private final GameChoiceResultRepository gameChoiceResultRepository;
    private final MemberRepository memberRepository;
    public Game save(Game game) {
        MemberEntity memberEntity = memberRepository.findByMemberId(game.getMemberId());
        var registerGame = GameEntity.forRegisterGame().memberEntity(memberEntity).game(game).build();
        return gameRepository.save(registerGame).toGame();
    }
    public Game joinGame(Long memberId,Long gameId,String givenChoice) {
        var choice = GameChoice.getChoice(givenChoice);
        final var gameEntity = findGameEntityByGameId(gameId);
        final var memberEntity = memberRepository.findByMemberId(memberId);
        var game = gameEntity.toGame();
        game.updateChoiceCount(choice);
        var updatedGameEntity = GameEntity.forUpdateGame().gameEntity(gameEntity).game(game).build();
        updatedGameEntity = gameRepository.save(updatedGameEntity);
        gameChoiceResultRepository.save(new GameChoiceResultEntity(memberEntity,updatedGameEntity,choice));
        return updatedGameEntity.toGame();
    }
    @Transactional(readOnly = true)
    public Game findGameByGameId(Long gameId) {
        return findGameEntityByGameId(gameId).toGame();
    }
    @Transactional(readOnly = true)
    public GameEntity findGameEntityByGameId(Long gameId) {
        return  gameRepository.findByGameId(gameId).orElseThrow(()->new IllegalStateException("[ERROR]"));
    }
    @Transactional(readOnly = true)
    public List<Game> findAll() {
        return gameRepository.findAll().stream().map(GameEntity::toGame).toList();
    }
}
