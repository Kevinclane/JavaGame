package com.JavaAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Encounter {

    @Id
    public String id;
    public String mainCharacterId;
    public String gameId;
    public ArrayList<Character> party;
    public ArrayList<Character> enemies;
    public ArrayList<String> turnRotation;
    public String whosTurn;
    public ArrayList<String> eventLog = new ArrayList<>();
    public ArrayList<Character> defeatedEnemies = new ArrayList<>();
    public ArrayList<Character> defeatedParty = new ArrayList<>();
    public String status;
    public DeathRewards rewards= new DeathRewards();

    public Encounter(String mainCharacterId, ArrayList<Character> enemies, ArrayList<Character> party, ArrayList<String> turnRotation, String gameId){
        this.mainCharacterId = mainCharacterId;
        this.party = party;
        this.enemies = enemies;
        this.whosTurn = turnRotation.get(0);
        turnRotation.remove(0);
        this.turnRotation = turnRotation;
        this.gameId = gameId;
    }

    public Encounter(){

    }

    public void setNextCharactersTurn(){
        this.whosTurn = this.turnRotation.get(0);
        this.turnRotation.remove(0);
    }

    public void addToEventLog(String message){
        this.eventLog.add(message);
    }

}
