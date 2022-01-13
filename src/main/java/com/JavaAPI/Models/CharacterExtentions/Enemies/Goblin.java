package com.JavaAPI.Models.CharacterExtentions.Enemies;

import com.JavaAPI.CharacterBuilders.GoblinBuilder;
import com.JavaAPI.Models.Character;

public class Goblin extends Character {

    public Goblin(int level){
        double levelModifier = (level - 1) * .05;

        GoblinBuilder goblinBuilder = new GoblinBuilder();
        this.name = "Goblin";
        this.inGameClass = "Goblin";
        this.health = (int) Math.round(goblinBuilder.healthBase + (goblinBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(goblinBuilder.strengthBase + (goblinBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(goblinBuilder.agilityBase + (goblinBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(goblinBuilder.intellectBase + (goblinBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(goblinBuilder.wisdomBase + (goblinBuilder.wisdomBase * levelModifier));
        this.mana =  this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = false;
        this.level = level;
    }
}
