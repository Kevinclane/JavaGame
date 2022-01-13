package com.JavaAPI.Models.SpellExtentions;

import com.JavaAPI.Models.Spell;

public class Spark extends Spell {

    public Spark(int level){
        this.name = "Spark";
        this.combatOnly = true;
        this.level = level;
        this.description = "A low level Electric Spell";
        this.element = "Lightning";
        this.manaCost = level * 4;
        this.damage = level * 2;
    }

}
