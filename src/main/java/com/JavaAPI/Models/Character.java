package com.JavaAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Character {

    @Id
    public String id;
    public String name;
    public String inGameClass;
    public String gameId;
    public int health;
    public int maxHealth;
    public int mana;
    public int maxMana;
    public int strength;
    public int agility;
    public int intellect;
    public int wisdom;
    public int exp;
    public int expToNextLevel;
    public int level;
    public Boolean friendly;
    public DeathRewards deathRewards;
    public int gold;
    public String spellbookId;


    public Spellbook spellbook;


    public Character() {

    }

    public Character(String name, String inGameClass, int health, int mana, int strength, int agility, int intellect, int wisdom, Boolean friendly, int level, String spellbookId, Spellbook spellbook) {
        this.name = name;
        this.inGameClass = inGameClass;
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.wisdom = wisdom;
        this.friendly = friendly;
        this.level = level;
        this.spellbookId = spellbookId;
        this.spellbook = spellbook;
    }

    public double calculateBasicAttackDamage(){
        return this.strength*2 + this.agility*1.5;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    private void _levelUp(){
        this.exp = this.exp - this.expToNextLevel;
        this.level ++;
        this.expToNextLevel = this.level * 50;
    }

    public void addRewards(DeathRewards rewards){
        this.exp += rewards.exp;
        this.gold += rewards.gold;
        if(this.exp >= this.expToNextLevel){
            _levelUp();
        }
    }

}
