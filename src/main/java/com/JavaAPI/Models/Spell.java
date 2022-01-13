package com.JavaAPI.Models;

public class Spell {
    public int level;
    public int damage;
    public int manaCost;
    public String element;
    public boolean combatOnly;
    public String description;
    public String name;

    public Spell(int level, int damage, int manaCost, String element, boolean combatOnly, String description, String name) {
        this.level = level;
        this.damage = damage;
        this.manaCost = manaCost;
        this.element = element;
        this.combatOnly = combatOnly;
        this.description = description;
        this.name = name;
    }
    public Spell(){

    }
}
