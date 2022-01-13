package com.JavaAPI.Models.CharacterExtentions.Party;

import com.JavaAPI.CharacterBuilders.MageBuilder;
import com.JavaAPI.Models.Character;

public class Mage extends Character {

    public Mage(String name, int level){
        double levelModifier = (level - 1) * .05;

        MageBuilder mageBuilder = new MageBuilder();
        this.name = name;
        this.inGameClass = "Mage";
        this.health = (int) Math.round(mageBuilder.healthBase + (mageBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(mageBuilder.strengthBase + (mageBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(mageBuilder.agilityBase + (mageBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(mageBuilder.intellectBase + (mageBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(mageBuilder.wisdomBase +(mageBuilder.wisdomBase * levelModifier));
        this.mana = this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = true;
        this.level = level;
    }
}
