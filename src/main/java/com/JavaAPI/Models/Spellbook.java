package com.JavaAPI.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Spellbook {
    @Id
    public String id;
    public String characterId;
    public String inGameClass;
    public ArrayList<Spell> spells;

    public Spellbook(String characterId, String inGameClass) {
        this.characterId = characterId;
        this.inGameClass = inGameClass;
    }
    public Spellbook(){

    }
}
