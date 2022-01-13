package com.JavaAPI.Services;

import com.JavaAPI.Models.DeathRewards;
import org.springframework.stereotype.Component;

@Component
public class DeathRewardsService {

    public DeathRewards createDeathRewards(int level){
        int gold;
        int exp = level * 5;

        if(level < 10){
            gold = 10;
        } else if(level < 20){
            gold = 30;
        } else if (level < 30){
            gold = 50;
        } else {
            gold = 75;
        }

        return new DeathRewards(exp, gold);
    }

}
