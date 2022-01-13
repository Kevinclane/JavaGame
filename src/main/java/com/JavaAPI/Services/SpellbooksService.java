package com.JavaAPI.Services;

import com.JavaAPI.Models.Character;
import com.JavaAPI.Models.Spellbook;
import com.JavaAPI.Models.SpellbookExtentions.MageSpellbook;
import com.JavaAPI.Models.SpellbookExtentions.WarriorSpellbook;
import com.JavaAPI.Repositories.SpellbooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SpellbooksService {

    @Autowired
    @Qualifier("SpellbookRepo")
    SpellbooksRepository _spellbooksRepository;

    public Spellbook createSpellbook(Character newCharacter) {
        Spellbook spellbook = new Spellbook();
        switch (newCharacter.inGameClass){
            case "Warrior" -> {
                spellbook = new WarriorSpellbook(newCharacter);
            }
            case "Mage" -> {
                spellbook = new MageSpellbook(newCharacter);
            }
            case "Ninja" -> {

            }
        }

        return _spellbooksRepository.save(spellbook);
    }


}
