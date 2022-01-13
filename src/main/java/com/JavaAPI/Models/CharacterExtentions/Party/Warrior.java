package com.JavaAPI.Models.CharacterExtentions.Party;

import com.JavaAPI.CharacterBuilders.WarriorBuilder;
import com.JavaAPI.Models.Character;

public class Warrior extends Character {

    public Warrior(String name, int level) {
        double levelModifier = (level - 1) * .05;

        this.name = name;
        this.inGameClass = "Warrior";
        WarriorBuilder warriorBuilder = new WarriorBuilder();
        this.health = (int) Math.round(warriorBuilder.healthBase + (warriorBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(warriorBuilder.strengthBase + (warriorBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(warriorBuilder.agilityBase + (warriorBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(warriorBuilder.intellectBase + (warriorBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(warriorBuilder.wisdomBase +(warriorBuilder.wisdomBase * levelModifier));
        this.mana = this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = true;
        this.level = level;
    }

}
