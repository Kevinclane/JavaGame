package com.JavaAPI.Services;

import com.JavaAPI.Models.Character;
import com.JavaAPI.Models.Spellbook;
import com.JavaAPI.Models.SpellbookExtentions.WarriorSpellbook;
import org.springframework.stereotype.Component;

@Component
public class SpellbooksService {

    public Spellbook createSpellbook(Character newCharacter) {
        Spellbook spellbook = new Spellbook();
        switch (newCharacter.inGameClass){
            case "Warrior" -> {
                spellbook = new WarriorSpellbook(spellbook, newCharacter);
            }
            case "Mage" -> {

            }
            case "Ninja" -> {

            }
        }
        return spellbook;
    }


}
