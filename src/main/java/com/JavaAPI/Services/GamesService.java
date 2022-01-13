package com.JavaAPI.Services;

import com.JavaAPI.Models.Encounter;
import com.JavaAPI.Models.Game;
import com.JavaAPI.Repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GamesService {

    @Autowired
    @Qualifier("GameRepo")
    private GamesRepository _gamesRepo;

    @Autowired
    private CharactersService _charactersService;

    public Optional<Game> loadGame(String gameId){
        return _gamesRepo.findById(gameId);
    }

    public Game createNewGame(Game newGame){
        var game = _gamesRepo.save(newGame);
        _charactersService.setGameToCharacter(game);
        return game;
    }

    public void battleWon(Encounter encounter) {
        var game = _gamesRepo.findById(encounter.gameId).orElseGet(Game::new);
        if(game.id != null){
            game.addExp(1);
        }
        _gamesRepo.save(game);
    }
}
