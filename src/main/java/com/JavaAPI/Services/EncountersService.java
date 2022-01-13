package com.JavaAPI.Services;

import com.JavaAPI.Models.Character;
import com.JavaAPI.Models.Encounter;
import com.JavaAPI.Models.RotationModel;
import com.JavaAPI.Repositories.CharactersRepository;
import com.JavaAPI.Repositories.EncountersRepository;
import com.JavaAPI.RequestModels.EncounterReq;
import com.JavaAPI.RequestModels.EncounterUserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class EncountersService {

    @Autowired
    @Qualifier("EncounterRepo")
    private EncountersRepository _encountersRepository;

    @Autowired
    private CharactersService _charactersService;

    @Autowired
    private GamesService _gamesService;

    private ArrayList<String> _generateTurnRotation(ArrayList<Character> party, ArrayList<Character> enemies){
        ArrayList<RotationModel> allCharacters = new ArrayList<>();
        for(Character c : party){
            allCharacters.add(new RotationModel(c.id,  c.agility));
        }
        for(Character c : enemies){
            allCharacters.add(new RotationModel(c.id,  c.agility));
        }

        ArrayList<String> ids = new ArrayList<>();

        int i = 100;
        while(i > 0){

            for (RotationModel c : allCharacters){
                c.count += c.agility;
                if(c.count >= 10){
                    ids.add(c.id);
                }
            }

            i--;
        }

        return ids;

    }

    public Optional<Encounter> getEncounter(String id) {
        return _encountersRepository.findById(id);
    }

    public Encounter createEncounter(EncounterReq req) {
        ArrayList<Character> party = _charactersService.loadParty(req.partyIds);
        ArrayList<Character> enemies = _charactersService.generateEnemies(req.enemyCount, req.level);
        ArrayList<String> turnRotation = _generateTurnRotation(party, enemies);
        Encounter encounter = new Encounter(req.partyIds[0],enemies, party, turnRotation, req.gameId);
        encounter = _encountersRepository.save(encounter);
        return encounter;
    }

    private  void _removeFromTurnRotation(Encounter encounter, Character character){
        encounter.turnRotation.removeIf(characterId -> characterId.equals(character.id));
        _encountersRepository.save(encounter);
    }

    private void _setDeathRewards(Encounter encounter){
        for(Character c : encounter.defeatedEnemies){
            encounter.rewards.exp += c.deathRewards.exp;
            encounter.rewards.gold += c.deathRewards.gold;
        }
        Character mainCharacter = _charactersService.getCharacter(encounter.mainCharacterId);
        mainCharacter.addRewards(encounter.rewards);
        _charactersService.save(mainCharacter);
    }

    private void _checkGameState(Encounter encounter){
        if(encounter.enemies.size() == 0){
            encounter.status = "Victory";
            _setDeathRewards(encounter);
            _gamesService.battleWon(encounter);
        } else if (encounter.party.size() == 0){
            encounter.status = "Defeat";
        }
    }

    private void _checkHealth(Encounter encounter, Character target){
        if(target.health <= 0){
            encounter.eventLog.add(target.name + " has been defeated");
            if(target.friendly){
                encounter.defeatedParty.add(target);
                encounter.party.remove(target);
                _removeFromTurnRotation(encounter, target);
            } else {
                encounter.defeatedEnemies.add(target);
                encounter.enemies.remove(target);
                _removeFromTurnRotation(encounter, target);
            }

            _checkGameState(encounter);
            _encountersRepository.save(encounter);
        }
    }

    private void _commitDamage(Encounter encounter, Character target, Character attacker){

        int damage = (int) Math.round(attacker.calculateBasicAttackDamage());

        if(attacker.friendly){
            for(Character c : encounter.enemies){
                if(c.id.equals(target.id)){
                    c.takeDamage(damage);
                    target = _charactersService.save(c);
                }
            }
        } else {
            for(Character c : encounter.party){
                if(c.id.equals(target.id)) {
                    c.takeDamage(damage);
                    target = _charactersService.save(c);
                }
            }
        }

        encounter.addToEventLog(attacker.name + " dealt " + damage + " damage to " + target.name);

        _checkHealth(encounter, target);

    }



    private Encounter attack(EncounterUserAction userAction){
        Encounter encounter = _encountersRepository.findById(userAction.encounterId).orElseGet(Encounter::new);

        Character attacker = _charactersService.getCharacter(userAction.characterId);
        Character target = _charactersService.getCharacter(userAction.targetId);

        _commitDamage(encounter, target, attacker);

        encounter.setNextCharactersTurn();

        encounter = _encountersRepository.save(encounter);
        return encounter;
    }

    //This function routes enemy moves
    public  Encounter checkIfEnemysTurn(Encounter encounter){
        Character whosTurnCharacter = _charactersService.getCharacter(encounter.whosTurn);
        if(!whosTurnCharacter.friendly){
            EncounterUserAction enemyAction = new EncounterUserAction("attack", whosTurnCharacter.id, encounter.party.get(0).id, false, encounter.id);
            encounter = attack(enemyAction);
        }
        return encounter;
    }

    //This function routes user moves
    public Encounter handleUserChoice(EncounterUserAction userAction) {
        switch (userAction.action){
            case "attack":
                return this.attack(userAction);
        }
        return new Encounter();
    }

    public void deleteEncounter(String encounterId) {
        _encountersRepository.deleteById(encounterId);
    }
}
