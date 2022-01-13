package com.JavaAPI.Models.CharacterExtentions.Enemies;

import com.JavaAPI.CharacterBuilders.BatBuilder;
import com.JavaAPI.Models.Character;

public class Bat extends Character {

    public Bat(int level){
        double levelModifier = (level - 1) * .05;

        BatBuilder batBuilder = new BatBuilder();
        this.name = "Bat";
        this.inGameClass = "Bat";
        this.health = (int) Math.round(batBuilder.healthBase + (batBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(batBuilder.strengthBase + (batBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(batBuilder.agilityBase + (batBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(batBuilder.intellectBase + (batBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(batBuilder.wisdomBase +(batBuilder.wisdomBase * levelModifier));
        this.mana =  this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = false;
        this.level = level;
    }
}
