package com.JavaAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DeathRewards {
    @Id
    public String id;
    public int exp;
    public int gold;

    public DeathRewards(int exp, int gold) {
        this.exp = exp;
        this.gold = gold;
    }
    public DeathRewards(){
        this.exp = 0;
        this.gold = 0;
    }
}
