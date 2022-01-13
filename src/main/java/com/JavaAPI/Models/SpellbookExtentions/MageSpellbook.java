package com.JavaAPI.Models.SpellbookExtentions;

import com.JavaAPI.Models.Character;
import com.JavaAPI.Models.Spell;
import com.JavaAPI.Models.SpellExtentions.Spark;
import com.JavaAPI.Models.Spellbook;

import java.util.ArrayList;

public class MageSpellbook extends Spellbook {

    public MageSpellbook(){

    }

    public MageSpellbook( Character character){
        super(character.id, character.inGameClass);
        this.spells = generateSpells(character.level);
    }


    private ArrayList<Spell> generateSpells(int level){
        var spells = new ArrayList<Spell>();
        switch (level){
            case 1 -> {
                spells.add(new Spark(1));
            }
            case 2 -> {

            }
            case 3 ->{

            }
        }
        return spells;
    }

}
