package com.JavaAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {

    @Id
    public String id;
    public String playerId;
    public String difficulty;
    public int restCost;
    public int level;
    public int exp = 0;

    public Game( String playerId, String difficulty, int level) {
        this.playerId = playerId;
        this.difficulty = difficulty;
        this.level = level;
        this.restCost = this.level * 2;
    }

    public Game(){

    }

    private void _levelUp(){
        this.level ++;
        this.exp = 0;
    }

    public void addExp(int exp){
        this.exp += exp;
        if(exp >= 10){
            _levelUp();
        }
    }
}
