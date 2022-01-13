package com.JavaAPI.Controllers;

import com.JavaAPI.Models.Game;
import com.JavaAPI.Services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GamesService _gamesService;

    @GetMapping("/game/load/{gameId}")
    public Optional<Game> loadGame(@PathVariable final String gameId) throws Exception {
        try {
            return _gamesService.loadGame(gameId);
        } catch (Exception err){
            throw new Exception(err);
        }
    }

    @PostMapping("/game/new")
    public Game createGame(@RequestBody final Game newGame) throws Exception {
        try {
            return _gamesService.createNewGame(newGame);
        } catch (Exception err){
            throw new Exception(err);
        }
    }
}
