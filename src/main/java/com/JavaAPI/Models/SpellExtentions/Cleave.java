package com.JavaAPI.Models.SpellExtentions;

import com.JavaAPI.Models.Spell;

public class Cleave extends Spell {

    public Cleave(int level){
        this.name = "Cleave";
        this.combatOnly = true;
        this.level = level;
        this.description = "Hits main target for 100% damage and all adjacent enemies with 60% damage";
        this.element = "Earth";
        this.manaCost = level * 3;
    }

}
