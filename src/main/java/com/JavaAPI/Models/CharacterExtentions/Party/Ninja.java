package com.JavaAPI.Models.CharacterExtentions.Party;

import com.JavaAPI.CharacterBuilders.NinjaBuilder;
import com.JavaAPI.Models.Character;

public class Ninja extends Character {

    public Ninja(String name, int level){
        double levelModifier = (level - 1) * .05;

        NinjaBuilder ninjaBuilder = new NinjaBuilder();
        this.name = name;
        this.inGameClass = "Ninja";
        this.health = (int) Math.round(ninjaBuilder.healthBase + (ninjaBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(ninjaBuilder.strengthBase + (ninjaBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(ninjaBuilder.agilityBase + (ninjaBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(ninjaBuilder.intellectBase + (ninjaBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(ninjaBuilder.wisdomBase +(ninjaBuilder.wisdomBase * levelModifier));
        this.mana = this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = true;
        this.level = level;
    }
}
