package com.JavaAPI.Services;

import com.JavaAPI.Models.Character;
import com.JavaAPI.Models.CharacterExtentions.Enemies.Goblin;
import com.JavaAPI.Models.CharacterExtentions.Enemies.Skeleton;
import com.JavaAPI.Models.CharacterExtentions.Enemies.Bat;
import com.JavaAPI.Models.CharacterExtentions.Party.Mage;
import com.JavaAPI.Models.CharacterExtentions.Party.Ninja;
import com.JavaAPI.Models.CharacterExtentions.Party.Warrior;
import com.JavaAPI.Models.Game;
import com.JavaAPI.Repositories.CharactersRepository;
import com.JavaAPI.RequestModels.CharacterReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CharactersService {

    @Autowired
    @Qualifier("CharRepo")
    private CharactersRepository _characterRepo;

    @Autowired
    private DeathRewardsService _deathRewardsService;

    @Autowired
    private SpellbooksService _spellbooksService;


    public Character getCharacter(String id){

        return _characterRepo.findById(id).orElseGet(Character::new);
    }

    private void _setInitialStats(Character character){
        character.friendly = true;
        character.gold = 10;
        character.exp = 0;
        character.level = 1;
        character.expToNextLevel = 50;
    }

    public Character createCharacter(CharacterReq characterReq){

        var newCharacter = new Character();
        switch (characterReq.inGameClass){
            case "Mage" -> {
                newCharacter = new Mage(characterReq.name, 1);
            }
            case "Warrior" -> {
                newCharacter = new Warrior(characterReq.name, 1);
            }
            case "Ninja" -> {
                newCharacter = new Ninja(characterReq.name, 1);
            }
        };
        _setInitialStats(newCharacter);
        newCharacter = _characterRepo.save(newCharacter);
        newCharacter.spellbook = _spellbooksService.createSpellbook(newCharacter);
        newCharacter.spellbookId = newCharacter.spellbook.id;
        newCharacter = _characterRepo.save(newCharacter);
        return newCharacter;
    }

    public List<Character> getAllCharacters(){
        return _characterRepo.findAll();
    }

    public void deleteCharacter(String id){
         _characterRepo.deleteById(id);
    }

    public ArrayList<Character> generateEnemies(int enemyCount, int level){
        var enemies = new ArrayList<Character>();

        int i = 0;
        while(i < enemyCount){

            int random = new Random().nextInt((3 - 1) + 1) + 1;

            switch (random) {
                case 1 -> {
                    var enemy = new Skeleton(level);
                    enemy.deathRewards = _deathRewardsService.createDeathRewards(enemy.level);
                    enemy = _characterRepo.save(enemy);
                    enemies.add(enemy);
                }
                case 2 -> {
                    var enemy = new Goblin(level);
                    enemy.deathRewards = _deathRewardsService.createDeathRewards(enemy.level);
                    enemy = _characterRepo.save(enemy);
                    enemies.add(enemy);
                }
                case 3 -> {
                    var enemy = new Bat(level);
                    enemy.deathRewards = _deathRewardsService.createDeathRewards(enemy.level);
                    enemy = _characterRepo.save(enemy);
                    enemies.add(enemy);
                }
            }

            i++;
        }

        return enemies;
    }

    public ArrayList<Character> loadParty(String[] partyIds) {
        ArrayList<Character> party = new ArrayList<>();
        for(String id : partyIds){
            var character = _characterRepo.findById(id).orElse(null);
            if(character != null){
                party.add(character);
            } else {
                System.out.println("Could not locate character with id: " + id);
            }
        }
        return party;
    }

    public List<Character> getListOfCharactersByIds(List<String> ids) {
        List<Character> foundCharacters = new ArrayList<>();
        for(String id : ids){
            var character = _characterRepo.findById(id).orElseGet(Character::new);
            if(character.id != null){
                foundCharacters.add(character);
            }
        }
        return foundCharacters;
    }

    public void setGameToCharacter(Game game) {
        var character = _characterRepo.findById(game.playerId).orElseGet(Character::new);
        if(character.id != null){
            character.gameId = game.id;
            _characterRepo.save(character);
        }
    }

    public Character save(Character character) {
        return _characterRepo.save(character);
    }

}
