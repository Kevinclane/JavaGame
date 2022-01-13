package com.JavaAPI.Models.CharacterExtentions.Enemies;

import com.JavaAPI.CharacterBuilders.SkeletonBuilder;
import com.JavaAPI.Models.Character;

public class Skeleton extends Character {

    public Skeleton(int level){
        double levelModifier = (level - 1) * .05;

        this.name = "Skeleton";
        this.inGameClass = "Skeleton";
        SkeletonBuilder skeletonBuilder = new SkeletonBuilder();
        this.health = (int) Math.round(skeletonBuilder.healthBase + (skeletonBuilder.healthBase * levelModifier));
        this.maxHealth = this.health;
        this.strength = (int) Math.round(skeletonBuilder.strengthBase + (skeletonBuilder.strengthBase * levelModifier));
        this.agility = (int) Math.round(skeletonBuilder.agilityBase + (skeletonBuilder.agilityBase * levelModifier));
        this.intellect = (int) Math.round(skeletonBuilder.intellectBase + (skeletonBuilder.intellectBase* levelModifier));
        this.wisdom = (int) Math.round(skeletonBuilder.wisdomBase +(skeletonBuilder.wisdomBase * levelModifier));
        this.mana = this.intellect * 3;
        this.maxMana = this.mana;
        this.friendly = false;
        this.level = level;
    }
}
